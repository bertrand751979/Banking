package com.example.mybankapplication.repository;

import static android.content.ContentValues.TAG;
import static com.example.mybankapplication.activities.MainActivity.MY_CHOICE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_OPERATION_KEY;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.fragment.DisplayOperationFragment;
import com.example.mybankapplication.fragment.EditOperationFragment;
import com.example.mybankapplication.fragment.SpinnerFragment;
import com.example.mybankapplication.models.Choice;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.models.Operation;
import com.example.mybankapplication.models.Solde;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Repository instance;
    private ArrayList<Choice> appChoiceList = new ArrayList<>();
    private ArrayList<Customer> appCustomerList = new ArrayList<>();
    public ArrayList<Operation> appOperationList = new ArrayList<>();
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

    public void operationPreference(Context context,EditText operationAccountNumber,EditText amount, String operationSelected, TextView date){
        Operation operation=new Operation();
        operation.setOperationAccountNumber(operationAccountNumber.getText().toString());
        operation.setAmount(Double.valueOf(amount.getText().toString()));
        operation.setChoiceOperation(operationSelected);
        operation.setDate(date.getText().toString());
        appOperationList.add(operation);
        SharedPreferencesManager.getInstance(context).saveOperation(appOperationList, MY_OPERATION_KEY);
        Toast.makeText(context,"La taille de la liste est: "+appOperationList.size(),Toast.LENGTH_SHORT).show();
    }

    public void spinnerPreference(Context context, EditText editSpinner){
        Choice choice=new Choice();
        choice.setChoiceSerlected(editSpinner.getText().toString());
        appChoiceList.add(choice);
        SharedPreferencesManager.getInstance(context).saveChoice(appChoiceList, MY_CHOICE_KEY);
        Toast.makeText(context, "la taille de la liste est:"+appChoiceList.size(), Toast.LENGTH_SHORT).show();
    }
    public List<Choice> getListChoice(Context context) {
        List<Choice> listChoice=SharedPreferencesManager.getInstance(context).getChoice(MY_CHOICE_KEY);
        return listChoice;
    }

    public void calculSolde(Context context, String accountNumber, Double resultat){
        for (Customer customer : SharedPreferencesManager.getInstance(context).getCustomer(MY_CUSTOMER_KEY)) {
            Log.i(TAG,"Le num de compte"+customer.getCustomerAccountNumber());
            for (Operation operation : SharedPreferencesManager.getInstance(context).getOperation(MY_OPERATION_KEY)){
                if (customer.getCustomerAccountNumber().equalsIgnoreCase(operation.getOperationAccountNumber())) {
                     Log.i(TAG,"Operation du numero de compte"+operation.getOperationAccountNumber());
                    accountNumber=operation.getOperationAccountNumber();
                    if(operation.getChoiceOperation().equalsIgnoreCase("Retrait")){
                        resultat=customer.getCustomerAmount()-operation.getAmount();
                        Log.i(TAG,"la somm est:"+resultat);
                        customer.setCustomerAmount(resultat);
                    }
                    if(operation.getChoiceOperation().equalsIgnoreCase("Depot")){
                        resultat=customer.getCustomerAmount()+operation.getAmount();
                        Log.i(TAG,"la somm est:"+resultat);
                        customer.setCustomerAmount(resultat);
                    }
                }
            }
        }

    }




}
