Simple Login App

Overview:

The Simple Login App is a basic Android application designed for users to log in by entering their username and password. 
Built entirely using Android Studio, the app includes both design and backend processes within the same environment.
It incorporates several essential features for a seamless and user-friendly login experience.

Features

Password Toggle:

Description: Allows users to toggle the visibility of the password in the input field.

How It Works:

A clickable eye icon is placed inside the password field.
Clicking the icon switches the password visibility between hidden and visible.
The icon dynamically changes based on the current state (visible or hidden).
Remember Me Functionality

Description: Saves the username for future logins, improving convenience.

How It Works:

A checkbox labeled "Remember Me" is added.
If checked, the username is saved in shared preferences and pre-filled on the next app launch.
If unchecked, the saved username is cleared.
Input Validation

Description: Ensures the username and password fields are not left empty before allowing login.

How It Works:

When the "Login" button is pressed, the app checks both fields.
If any field is empty, a toast message prompts the user to fill in all fields.
Toast Message

Description: Displays feedback to the user upon successful login.

How It Works:

After successful validation, a toast message is displayed, stating "Login successful," to confirm the action.

Technologies Used:

Android Studio: Used for designing and implementing both the front-end and back-end functionalities of the app.
Java/Kotlin: This is built with help of Kotlin
