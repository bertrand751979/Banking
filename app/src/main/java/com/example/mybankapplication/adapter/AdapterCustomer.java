package com.example.mybankapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.viewHolder.CustomerViewHolder;

import java.util.ArrayList;

public class AdapterCustomer extends RecyclerView.Adapter<CustomerViewHolder> {
    private ArrayList<Customer>listCustomerAdapter;

    public AdapterCustomer(ArrayList<Customer> listCustomerAdapter) {
        this.listCustomerAdapter = listCustomerAdapter;
    }

    public void setListCustomerAdapter(ArrayList<Customer> listCustomerAdapter) {
        this.listCustomerAdapter = listCustomerAdapter;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.raw_customer,parent,false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.bind(listCustomerAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listCustomerAdapter.size();
    }
}
