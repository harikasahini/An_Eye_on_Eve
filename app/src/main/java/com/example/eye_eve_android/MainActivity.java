package com.example.eye_eve_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
    }

    public void onClickSignin(View v){
        EditText newUserName = findViewById(R.id.username);
        EditText newPassword = findViewById(R.id.password);
        if (newUserName.getText().toString().trim().equalsIgnoreCase("")) {
            newUserName.setError("username is required");
        } else if (newPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newPassword.setError("password is required");
        } else {
            Toast t = Toast.makeText(this, "Login Done Succesfully!", Toast.LENGTH_SHORT);t.show();
            String userName = newUserName.getText().toString();
            String password = newPassword.getText().toString();
            intent.putExtra("userName", userName);
            intent.putExtra("password", password);
            setResult(Activity.RESULT_OK, intent);
            finish();

            Intent k=new Intent(this,UserView.class);
            startActivity(k);

        }
    }

    public void onClickRegister(View v){

        Intent i=new Intent(this,RegistertoApp.class);
        startActivity(i);
    }
}