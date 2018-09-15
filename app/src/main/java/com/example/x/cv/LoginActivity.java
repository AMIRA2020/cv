package com.example.x.cv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_FIRST_NAME = "key-first-name";
    public static final String KEY_SECOND_NAME = "key-second-name";
    public static final String KEY_EMAIL = "key-email";
    public static final String KEY_PASSWORD = "key-password";
    public static final String KEY_REMEMBER_ME = "key-remember-me";
    private SharedPreferences sharedPreferences;
    private EditText firstNameEditText, secondNameEditText, emailEditText, passwordEditText;
    private Button loginButton;
    private CheckBox rememberMeCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);

        // check if remember me is enabled
        if (sharedPreferences.getBoolean(KEY_REMEMBER_ME, false)) {

            // goto welcome screen, and finish LoginActivity
            startActivity(new Intent(LoginActivity.this, Welcome.class));
            finish();
        }

        // views initialization and events handling
        init();
    }

    private void init() {

        firstNameEditText = findViewById(R.id.first_name_editText);
        secondNameEditText = findViewById(R.id.last_name_editText);
        emailEditText = findViewById(R.id.email_editText);
        passwordEditText = findViewById(R.id.password_editText);
        loginButton = findViewById(R.id.submit_button);
        rememberMeCheckBox = findViewById(R.id.rem_check);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putString(KEY_FIRST_NAME, firstNameEditText.getText().toString()).commit();
                sharedPreferences.edit().putString(KEY_SECOND_NAME, secondNameEditText.getText().toString()).commit();
                sharedPreferences.edit().putString(KEY_EMAIL, emailEditText.getText().toString()).commit();
                sharedPreferences.edit().putString(KEY_PASSWORD, passwordEditText.getText().toString()).commit();
                sharedPreferences.edit().putBoolean(KEY_REMEMBER_ME, rememberMeCheckBox.isChecked()).commit();

                if (!isValidfName(firstNameEditText.getText().toString().trim())) {
                    firstNameEditText.setError(getResources().getString(R.string.fnamemessage));
                } else if (!isValidlName(secondNameEditText.getText().toString().trim())) {
                    secondNameEditText.setError(getResources().getString(R.string.lnamemessage));
                } else if (!isValidEmail(emailEditText.getText().toString().trim())) {
                    emailEditText.setError(getResources().getString(R.string.emailmessage));
                } else{
                    startActivity(new Intent(LoginActivity.this, Welcome.class));
               // finish();
                }

                }
            });
        }


    public boolean isValidEmail(String Email) {

        boolean check;

        Pattern p = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
        Matcher m = p.matcher(Email);

        if (m.find()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    /*public boolean isValidPassword(String Password) {

        boolean check;

        Pattern p = Pattern.compile("1");
        Matcher m = p.matcher(Password);
        if (m.find()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }*/

    public boolean isValidfName(String firstNameEditText) {

        boolean check;

        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(firstNameEditText);
        if (m.find()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
    public boolean isValidlName(String lName) {

        boolean check;

        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(lName);
        if (m.find()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

}

