package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var passwordToggle: ImageView
    private lateinit var rememberMeCheckbox: CheckBox
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        passwordToggle = findViewById(R.id.password_toggle)
        rememberMeCheckbox = findViewById(R.id.remember_me_checkbox)
        loginBtn = findViewById(R.id.login_btn)

        // Restore remembered username
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val savedUsername = sharedPref.getString("SAVED_USERNAME", "")
        if (savedUsername != null && savedUsername.isNotEmpty()) {
            usernameInput.setText(savedUsername)
            rememberMeCheckbox.isChecked = true
        }

        // Password toggle functionality
        passwordToggle.setOnClickListener {
            if (passwordInput.inputType == android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD or android.text.InputType.TYPE_CLASS_TEXT) {
                passwordInput.inputType = android.text.InputType.TYPE_CLASS_TEXT
                passwordToggle.setImageResource(R.drawable.ic_eye_off)
            } else {
                passwordInput.inputType = android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD or android.text.InputType.TYPE_CLASS_TEXT
                passwordToggle.setImageResource(R.drawable.ic_eye)
            }
            passwordInput.setSelection(passwordInput.text.length) // Retain cursor position
        }

        // Login button functionality
        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rememberMeCheckbox.isChecked) {
                sharedPref.edit().putString("SAVED_USERNAME", username).apply()
            } else {
                sharedPref.edit().remove("SAVED_USERNAME").apply()
            }

            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            Log.i("Test Credentials", "Username: $username and Password: $password")
        }

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
