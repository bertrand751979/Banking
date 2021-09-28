package com.example.mybankapplication.fragment;

import static com.example.mybankapplication.activities.EditCustomerActivity.myCustomerList;
import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMERSOLDE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.activities.EditCustomerActivity;
import com.example.mybankapplication.adapter.AdapterCustomer;
import com.example.mybankapplication.models.Customer;

import java.util.ArrayList;

public class SoldeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Customer>myListSoldCustomer=new ArrayList<>();
    private AdapterCustomer customerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myListSoldCustomer.clear();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_customer,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myListSoldCustomer=new ArrayList<Customer>(SharedPreferencesManager.getInstance(SoldeFragment.this.getContext()).getCustomer(MY_CUSTOMERSOLDE_KEY));
        recyclerView=view.findViewById(R.id.recyclerViewListCustomers);
        setViewItem();

    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(SoldeFragment.this.getContext()));
        customerAdapter=new AdapterCustomer(myCustomerList);
        customerAdapter=new AdapterCustomer(myListSoldCustomer);
        recyclerView.setAdapter(customerAdapter);
    }





}

