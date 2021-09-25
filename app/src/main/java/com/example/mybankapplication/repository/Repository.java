package com.example.mybankapplication.repository;

import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.models.Choice;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.models.Operation;
import com.example.mybankapplication.models.Solde;

import java.util.ArrayList;

public class Repository {

    private static Repository instance;
    private ArrayList<Choice> appChoiceList = new ArrayList<>();
    private ArrayList<Customer> appCustomerList = new ArrayList<>();
    public ArrayList<Operation> appOperationGroupe = new ArrayList<>();
    private ArrayList<Solde> appSoldeList = new ArrayList<>();

    private Repository() {
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void customerPreference(Context context, EditText editSurname,EditText editName, EditText editCustomerId,EditText editCustomerAmount ) {
        Customer customer=new Customer();
        customer.setCustomerSurname(editSurname.getText().toString());
        customer.setCustomerName(editName.getText().toString());
        customer.setCustomerAccountNumber(editCustomerId.getText().toString());
        customer.setCustomerAmount(Double.valueOf(editCustomerAmount.getText().toString()));
        appCustomerList.add(customer);
        Toast.makeText(context,"La liste contient "+appCustomerList.size(),Toast.LENGTH_SHORT).show();
        SharedPreferencesManager.getInstance(context).saveCustomer(appCustomerList,MY_CUSTOMER_KEY);
    }
}
