package com.example.mybankapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mybankapplication.fragment.DisplayCustomerFragment;
import com.example.mybankapplication.fragment.DisplayOperationFragment;
import com.example.mybankapplication.R;
import com.example.mybankapplication.fragment.EditOperationFragment;
import com.example.mybankapplication.fragment.SpinnerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static String MY_CUSTOMER_KEY="myCustomerKeys";
    public static String MY_CHOICE_KEY="myChoiceKeys";
    public static String MY_OPERATION_KEY="myOperationKeys";
    //private FloatingActionButton fab;
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
       /* fab=findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EditCustomerActivity.class);
                startActivity(intent);
            }
        });*/
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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

}