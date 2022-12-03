package com.example.eve;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eve.ui.home.HomeFragment;
import com.example.eve.ui.home.HomeViewModel;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import com.parse.LogInCallback;

import android.app.ProgressDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);


    }

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    public void onClickSignin(View v) {
        // testBackForApp();
        EditText newUserName = findViewById(R.id.username);
        EditText newPassword = findViewById(R.id.password);
        radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if(selectedId<=0){
            Toast.makeText(MainActivity.this, "Please select one login option!", Toast.LENGTH_SHORT).show();
        }
        else if (newUserName.getText().toString().trim().equalsIgnoreCase("")) {
            newUserName.setError("username is required");
        } else if (newPassword.getText().toString().trim().equalsIgnoreCase("")) {
            newPassword.setError("password is required");
        } else {

            String userName = newUserName.getText().toString();
            String password = newPassword.getText().toString();
//            Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            progressDialog.show();
            ParseUser.logInInBackground(userName, password, (parseUser, e) -> {
                progressDialog.dismiss();
                if (parseUser != null) {
                    if (radioButton.getText().equals("Log in as user")) {
                        Intent UV = new Intent(this, NavdrawerUserActivity.class);
                        startActivity(UV);
                        Toast t = Toast.makeText(this, "Successful Login!\n"+userName+" Logged in as user.", Toast.LENGTH_SHORT);
                        t.show();
                    } else if (radioButton.getText().equals("Log in as organizer")) {
                        Intent OV = new Intent(this, NavdrawerOrganizerActivity.class);
                        startActivity(OV);
                        Toast t = Toast.makeText(this, "Successful Login!\n"+userName+" Logged in as Organizer.", Toast.LENGTH_SHORT);
                        t.show();
                    }
                } else {
                    ParseUser.logOut();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }


//        mStartForResult.launch(i);
//         = intent.getExtras().getString("EventName");

//    public void testBackForApp(){
////        Log.v("Running: ","testBackForApp");
//        //Saving your First data object on Back4App
//        ParseObject person = new ParseObject("Person");
//        person.put("name", "");
//        person.put("age", 27);
//        person.saveInBackground();
//    }

    public void onClickRegisterR(View view) {
        Intent i=new Intent(this,Register.class);
        startActivity(i);
    }
}