import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val excelFilePath = "QRData.xlsx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scanQRButton: Button = findViewById(R.id.btn_scan_qr)
        scanQRButton.setOnClickListener {
            // Check for storage permissions before scanning
            if (checkStoragePermission()) {
                startQRCodeScanner()
            }
        }
    }

    // QR code scanner setup
    private fun startQRCodeScanner() {
        val options = ScanOptions()
        options.setPrompt("Scan a QR code")
        options.setBeepEnabled(true)
        options.setOrientationLocked(false)
        qrCodeLauncher.launch(options)
    }

    // QR code scan result handler
    private val qrCodeLauncher = registerForActivityResult(ScanContract()) { result ->
        result.contents?.let { qrData ->
            saveDataToExcel(qrData)
        }
    }

    // Function to save scanned data to Excel file
    private fun saveDataToExcel(qrData: String) {
        val file = File(getExternalFilesDir(null), excelFilePath)
        try {
            val workbook = if (file.exists()) {
                WorkbookFactory.create(file) // Open existing workbook if exists
            } else {
                XSSFWorkbook().apply {
                    createSheet("QR Data").apply {
                        createRow(0).createCell(0).setCellValue("QR Data") // Add header
                    }
                }
            }

            // Write data to a new row
            val sheet = workbook.getSheetAt(0)
            val newRow: Row = sheet.createRow(sheet.lastRowNum + 1)
            newRow.createCell(0).setCellValue(qrData)

            // Save the file
            FileOutputStream(file).use { outputStream ->
                workbook.write(outputStream)
                workbook.close()
            }
            Toast.makeText(this, "Data saved to Excel file", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
        }
    }

    // Check and request storage permissions
    private fun checkStoragePermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_WRITE_PERMISSION)
            false
        } else {
            true
        }
    }

    companion object {
        const val REQUEST_WRITE_PERMISSION = 100
    }
}