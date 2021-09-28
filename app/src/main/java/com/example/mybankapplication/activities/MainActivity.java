package com.example.mybankapplication.activities;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.mybankapplication.fragment.DisplayCustomerFragment;
import com.example.mybankapplication.fragment.DisplayOperationFragment;
import com.example.mybankapplication.R;
import com.example.mybankapplication.fragment.EditOperationFragment;
import com.example.mybankapplication.fragment.SoldeFragment;
import com.example.mybankapplication.fragment.SpinnerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static String MY_CUSTOMER_KEY="myCustomerKeysss";
    public static String MY_CHOICE_KEY="myChoiceKeys";
    public static String MY_OPERATION_KEY="myOperationKeys";
    public static String MY_CUSTOMERSOLDE_KEY="myCustomerSoldeKey";
    private BottomNavigationView bottomNav;

    @Override
    protected void onResume() {
        super.onResume();
        bottomNav.setSelectedItemId(R.id.nav_customer_list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_customer_list:
                    selectedFragment = new DisplayCustomerFragment();
                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_edit_spinner:
                    selectedFragment = new SpinnerFragment();
                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_edit_operation:
                    selectedFragment = new EditOperationFragment();
                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_operation_list:
                    selectedFragment = new DisplayOperationFragment();
                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_customer_solde:
                    selectedFragment = new SoldeFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

}