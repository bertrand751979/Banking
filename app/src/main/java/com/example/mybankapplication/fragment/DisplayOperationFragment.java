package com.example.mybankapplication.fragment;

import static android.content.ContentValues.TAG;
import static com.example.mybankapplication.activities.MainActivity.MY_CHOICE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMERSOLDE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_OPERATION_KEY;
import static com.example.mybankapplication.fragment.EditOperationFragment.myOperationList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.adapter.AdapterOperation;
import com.example.mybankapplication.models.Choice;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.models.Operation;
import com.example.mybankapplication.models.Solde;
import com.example.mybankapplication.repository.Repository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DisplayOperationFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterOperation operationAdapter;
    private ArrayList<Operation> myOperationList=new ArrayList<>();
    private Button btnSolde;
    double somme=0;
    private ArrayList<Customer> myListSoldeCustomer=new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myOperationList=new ArrayList<Operation>(SharedPreferencesManager.getInstance(DisplayOperationFragment.this.getContext()).getOperation(MY_OPERATION_KEY));

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_operation,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSolde=view.findViewById(R.id.btnCalculSolde);
        btnSolde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Customer customer= new Customer();
            customer.setCustomerName(customer.getCustomerName());
            customer.setCustomerAmount(somme);
            myListSoldeCustomer.add(customer);
            SharedPreferencesManager.getInstance(DisplayOperationFragment.this.getContext()).saveCustomer(myListSoldeCustomer,MY_CUSTOMERSOLDE_KEY);
                Toast.makeText(DisplayOperationFragment.this.getContext(),"la taille de la list est: "+
                        myListSoldeCustomer.size(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = view.findViewById(R.id.recyclerViewListOperation);
        setViewItem();
        updateSolde();
    }
    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayOperationFragment.this.getContext()));
        operationAdapter=new AdapterOperation(myOperationList);
        recyclerView.setAdapter(operationAdapter);
    }
    public void updateSolde() {

        for (Customer customer : SharedPreferencesManager.getInstance
                (DisplayOperationFragment.this.getContext()).getCustomer(MY_CUSTOMER_KEY)) {
            Log.i(TAG,"Le num de compte"+customer.getCustomerAccountNumber());
            for (Operation operation : SharedPreferencesManager.getInstance
                    (DisplayOperationFragment.this.getContext()).getOperation(MY_OPERATION_KEY)){
                if (customer.getCustomerAccountNumber().equalsIgnoreCase(operation.getOperationAccountNumber())) {
                   // Log.i(TAG,"Operation du numero de compte"+operation.getOperationAccountNumber());
                    if(operation.getChoiceOperation().equalsIgnoreCase("Retrait")){
                        somme=customer.getCustomerAmount()-operation.getAmount();
                        Log.i(TAG,"la somm est:"+somme);
                        customer.setCustomerAmount(somme);
                    }
                    if(operation.getChoiceOperation().equalsIgnoreCase("Depot")){
                        somme=customer.getCustomerAmount()+operation.getAmount();
                        Log.i(TAG,"la somm est:"+somme);
                        customer.setCustomerAmount(somme);
                    }
                }

            }

        }

    }//fin UpdateSolde()
}//fin de Display
