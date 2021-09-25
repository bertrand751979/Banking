package com.example.mybankapplication.activities;

import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.repository.Repository;

import java.util.ArrayList;

public class EditCustomerActivity extends AppCompatActivity {
    private EditText editSurname;
    private EditText editName;
    private EditText editCustomerId;
    private EditText editCustomerAmount;
    private Button btnSave;
    public static ArrayList<Customer> myCustomerList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_customer);
        editSurname=findViewById(R.id.edit_customer_surname);
        editName=findViewById(R.id.edit_customer_name);
        editCustomerAmount=findViewById(R.id.edit_customer_amount);
        editCustomerId=findViewById(R.id.edit_customer_id);
        btnSave=findViewById(R.id.btnCustomerSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
            }
        });
    }

    private void addCustomer(){
        Repository.getInstance().customerPreference(this,editSurname,editName,editCustomerId,editCustomerAmount);
      /*  Customer customer=new Customer();
        customer.setCustomerSurname(editSurname.getText().toString());
        customer.setCustomerName(editName.getText().toString());
        customer.setCustomerAccountNumber(editCustomerId.getText().toString());
        customer.setCustomerAmount(Double.valueOf(editCustomerAmount.getText().toString()));
        myCustomerList.add(customer);
        Toast.makeText(this,"La liste contient "+myCustomerList.size(),Toast.LENGTH_SHORT).show();
        SharedPreferencesManager.getInstance(this).saveCustomer(myCustomerList,MY_CUSTOMER_KEY);*/
        finish();

    }





}
