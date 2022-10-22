package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    public void onClickRegisterR(View v){
        EditText newFullName = findViewById(R.id.fullName);
        EditText newEmail = findViewById(R.id.EmailAddress);
        EditText newEnterPassword = findViewById(R.id.enterpassword);
        EditText newConfirmPassword = findViewById(R.id.confirmpassword);
        radioGroup = findViewById(R.id.radioGroup2);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if(selectedId<=0){
        Toast.makeText(RegistertoApp.this, "Please select one radio option!", Toast.LENGTH_SHORT).show();
        }
        else if (newFullName.getText().toString().trim().equalsIgnoreCase("")) {
            newFullName.setError("Full Name is required!");
        } else if (newEmail.getText().toString().trim().equalsIgnoreCase("")) {
            newEmail.setError("Email address is required!");
        } else if (newEnterPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newEnterPassword.setError("Password is required!");
        } else if (newConfirmPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newConfirmPassword.setError("Please confirm your password!!");
        }
        else if(!(newEnterPassword.getText().toString().equals(newConfirmPassword.getText().toString()))){
            Toast.makeText(RegistertoApp.this, "Password's didn't match. Please try again!", Toast.LENGTH_SHORT).show();

        }
        else if(newEnterPassword.getText().toString().length()<8){
            Toast.makeText(RegistertoApp.this, "Use 8 characters or more for your password!", Toast.LENGTH_SHORT).show();
        }
        else if(!(newEnterPassword.getText().toString().matches(".*[A-Z].*"))){
            Toast.makeText(RegistertoApp.this, "Password should contain atleast one upper case letter!!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast t = Toast.makeText(this, "Registered Succesfully!", Toast.LENGTH_SHORT);t.show();
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
//            String fullName = newFullName.getText().toString();
//            String email = newEmail.getText().toString();
//            String enterPassword = newEnterPassword.getText().toString();
//            String confirmPassword = newConfirmPassword.getText().toString();
//            intent.putExtra("fullName", fullName);
//            intent.putExtra("email", email);
//            intent.putExtra("enterPassword", enterPassword);
//            intent.putExtra("confirmPassword", confirmPassword);
//            setResult(Activity.RESULT_OK, intent);
//            finish();
        }

    }
}