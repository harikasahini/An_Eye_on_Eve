package com.example.eve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.eve.databinding.ActivityNavdrawerOrganizerBinding;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class NavdrawerOrganizerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavdrawerOrganizerBinding binding;
    static NavController navController;
    private static int flagback=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavdrawerOrganizerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarNavdrawerOrganizer.toolbar);
        binding.appBarNavdrawerOrganizer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayoutOrg;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_View_organizations, R.id.nav_about,R.id.action_settings)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navdrawer_organizer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public static void onchy(){
        navController.navigate(R.id.nav_creation);
    }
    public static void onCreateNewEve(Bundle evedetails){
        navController.navigate(R.id.nav_home,evedetails);
    }
    public static void onSelectOrgOV(){
        navController.navigate(R.id.nav_home);
        flagback=0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navdrawer_organizer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem m){

        int id=m.getItemId();
        if(id==R.id.action_settings){
            Intent i =new Intent(this,MainActivity.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Logged out successfully!!",Toast.LENGTH_LONG).show();
            return true;
        }
        else{
            super.onOptionsItemSelected(m);
        }

        return false;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navdrawer_organizer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if(flagback==0)
        {
            OrganizationAdapter.resetListEvents();
            flagback=1;
            super.onBackPressed();
        }
        else {
            super.onBackPressed();
        }
    }
}