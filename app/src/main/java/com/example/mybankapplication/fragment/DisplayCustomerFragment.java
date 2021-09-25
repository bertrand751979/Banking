package com.example.mybankapplication.fragment;

import static com.example.mybankapplication.activities.MainActivity.MY_CUSTOMER_KEY;

import android.content.Intent;
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
import com.example.mybankapplication.activities.MainActivity;
import com.example.mybankapplication.adapter.AdapterCustomer;
import com.example.mybankapplication.models.Customer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DisplayCustomerFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterCustomer customerAdapter;
    private ArrayList<Customer>myCustomerList=new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
        myCustomerList=new ArrayList<Customer>(SharedPreferencesManager.getInstance(DisplayCustomerFragment.this.getContext()).getCustomer(MY_CUSTOMER_KEY));
        recyclerView=view.findViewById(R.id.recyclerViewListCustomers);


        setViewItem();

    }
    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayCustomerFragment.this.getContext()));
        customerAdapter=new AdapterCustomer(myCustomerList);
        recyclerView.setAdapter(customerAdapter);


    }

}
