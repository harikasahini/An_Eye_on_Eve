package com.example.eve;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.SignUpCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Register extends AppCompatActivity {
    private EditText regUsername, regPassword ,regConfirmPassword,regEmail;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(Register.this);
        regUsername=findViewById(R.id.fullName);
        regEmail=findViewById(R.id.EmailAddress);
        regPassword=findViewById(R.id.enterpassword);
        regConfirmPassword=findViewById(R.id.confirmpassword);
    }

    public void onClickSigninR(View v) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    public void onClickRegisterR(View v) {
        EditText newFullName = findViewById(R.id.fullName);
        EditText newEmail = findViewById(R.id.EmailAddress);
        EditText newLocation= findViewById(R.id.location);
        EditText newEnterPassword = findViewById(R.id.enterpassword);
        EditText newConfirmPassword = findViewById(R.id.confirmpassword);
        radioGroup = findViewById(R.id.radioGroup2);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (selectedId <= 0) {
            Toast.makeText(Register.this, "Please select one radio option!", Toast.LENGTH_SHORT).show();
        } else if (newFullName.getText().toString().trim().equalsIgnoreCase("")) {
            newFullName.setError("Full Name is required!");
        } else if (newEmail.getText().toString().trim().equalsIgnoreCase("")) {
            newEmail.setError("Email address is required!");
        } else if (newLocation.getText().toString().trim().equalsIgnoreCase("")) {
            newLocation.setError("Location is required!");
        } else if (newEnterPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newEnterPassword.setError("Password is required!");
        } else if (newConfirmPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newConfirmPassword.setError("Please confirm your password!!");
        } else if (!(newEnterPassword.getText().toString().equals(newConfirmPassword.getText().toString()))) {
            Toast.makeText(Register.this, "Password's didn't match. Please try again!", Toast.LENGTH_SHORT).show();

        } else if (newEnterPassword.getText().toString().length() < 8) {
            Toast.makeText(Register.this, "Use 8 characters or more for your password!", Toast.LENGTH_SHORT).show();
        } else if (!(newEnterPassword.getText().toString().matches(".*[A-Z].*"))) {
            Toast.makeText(Register.this, "Password should contain atleast one upper case letter!!", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("on register details","I am at start");
            ParseUser user = new ParseUser();
            Log.d("on register details","setting up");
            // Set the user's username and password, which can be obtained by a forms
            try{
            user.setUsername(regUsername.getText().toString());
            user.setPassword(regPassword.getText().toString());
            user.setEmail(regEmail.getText().toString());
            user.put("fullName",newFullName.getText().toString());
            user.put("location",newLocation.getText().toString());
                Log.d("on register details","i am upp up");
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    Log.d("on register details","i am upp up2");
                    if (e == null) {
                        showAlert("Successful Sign Up!", "Welcome" + regUsername.getText().toString() + "!");
                        Intent i = new Intent(Register.this,MainActivity.class);
                        startActivity(i);
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }

            }
            );
            }
            catch(Exception e)
            {
                Log.d("in register",e.toString());
            }
//            Toast t = Toast.makeText(this, "Registered Succesfully!", Toast.LENGTH_SHORT);
//            t.show();
//            Intent i = new Intent(this, MainActivity.class);
//            startActivity(i);
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
    private void showAlert(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (radioButton.getText().equals("Log in as user")) {
                            Intent UV = new Intent(Register.this, NavdrawerUserActivity.class);
                            startActivity(UV);
                            Toast t = Toast.makeText(Register.this, "Successful SignUp as user!\n"+regUsername.getText().toString()+" Logged in as user.", Toast.LENGTH_SHORT);
                            t.show();
                        } else if (radioButton.getText().equals("Log in as organizer")) {
                            Intent OV = new Intent(Register.this, NavdrawerOrganizerActivity.class);
                            startActivity(OV);
                            Toast t = Toast.makeText(Register.this, "Successful SignUp as organizer!\n"+regUsername.getText().toString()+" Logged in as Organizer.", Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}