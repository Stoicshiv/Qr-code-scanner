# QR Code Scanner App

Welcome to the QR Code Scanner App! This application allows users to scan QR codes using their Android devices, extract the data from the codes, and save it into an Excel sheet. Built with Kotlin and leveraging the ZXing library for QR code scanning, this app is both user-friendly and efficient.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features
- Scan QR codes using your device's camera.
- Display the scanned data in an easy-to-read format.
- Export scanned data to an Excel sheet for easy management.
- User-friendly interface with simple navigation.

## Installation

### Prerequisites
- Android Studio installed on your machine.
- Basic understanding of Kotlin programming.

### Steps to Install
1. Clone the repository:
   ```bash
   git clone https://github.com/Stoicshiv/qr-code-scanner-app.git
Open the project in Android Studio.

Ensure you have the following permissions added in the AndroidManifest.xml:
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
Add the ZXing library to your build.gradle (app level):
dependencies {
    implementation 'com.journeyapps:zxing-android-embedded:4.3.0'
    implementation 'com.google.zxing:core:3.4.1'
}
Sync the project with Gradle files.

Usage
Launch the QR Code Scanner app on your Android device.
Allow the app to access your camera.
Point your camera at the QR code you wish to scan.
The scanned data will be displayed on the screen.
Tap the "Export" button to save the scanned data to an Excel sheet.
Technologies Used
Kotlin
Android SDK
ZXing Library for QR code scanning
Apache POI for Excel file creation
Contributing
We welcome contributions! Please feel free to submit a pull request or open an issue to discuss improvements or bug fixes.

Fork the repository.
Create a new branch (git checkout -b feature/YourFeatureName).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/YourFeatureName).
Open a pull request.
License
This project is licensed under the MIT License. See the LICENSE file for more details.

Thank you for using the QR Code Scanner App! If you have any questions or feedback, please reach out.

### Notes:
- Replace `https://github.com/Stoicshiv/qr-code-scanner-app.git` with the actual URL of your repository.
- Feel free to customize the content to better fit your app’s specific features and functionality.
