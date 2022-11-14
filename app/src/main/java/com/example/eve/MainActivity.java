package com.example.eve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.eve.ui.home.HomeFragment;
import com.example.eve.ui.home.HomeViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    public void onClickSignin(View v) {
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

//            String userName = newUserName.getText().toString();
//            String password = newPassword.getText().toString();
//            Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            if (radioButton.getText().equals("Log in as user")) {
                Intent UV = new Intent(this, NavdrawerUserActivity.class);
                startActivity(UV);
                Toast t = Toast.makeText(this, "Logged in as user!", Toast.LENGTH_SHORT);
                t.show();
            } else if (radioButton.getText().equals("Log in as organizer")) {
                Intent OV = new Intent(this, NavdrawerOrganizerActivity.class);
                startActivity(OV);
                Toast t = Toast.makeText(this, "Logged in as Organizer!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    public void onClickRegister(View v){
        Intent i=new Intent(this,Register.class);
        startActivity(i);
//        mStartForResult.launch(i);
//         = intent.getExtras().getString("EventName");
    }
}