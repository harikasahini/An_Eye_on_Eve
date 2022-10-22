package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistertoApp extends AppCompatActivity {
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerto_app);
    }

    public void onClickSigninR(View v){

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void onClickRegisterR(View v){
        EditText newFullName = findViewById(R.id.fullName);
        EditText newEmail = findViewById(R.id.EmailAddress);
        EditText newEnterPassword = findViewById(R.id.enterpassword);
        EditText newConfirmPassword = findViewById(R.id.confirmpassword);
        if (newFullName.getText().toString().trim().equalsIgnoreCase("")) {
            newFullName.setError("fullname is required");
        } else if (newEmail.getText().toString().trim().equalsIgnoreCase("")) {
            newEmail.setError("email address is required");
        } else if (newEnterPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newEnterPassword.setError(" You must enter the password is required");
        } else if (newConfirmPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newConfirmPassword.setError("You must confirm the password is required");
        } else {
            Toast t = Toast.makeText(this, "Registered Succesfully!", Toast.LENGTH_SHORT);t.show();
            String fullName = newFullName.getText().toString();
            String email = newEmail.getText().toString();
            String enterPassword = newEnterPassword.getText().toString();
            String confirmPassword = newConfirmPassword.getText().toString();
            intent.putExtra("fullName", fullName);
            intent.putExtra("email", email);
            intent.putExtra("enterPassword", enterPassword);
            intent.putExtra("confirmPassword", confirmPassword);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}