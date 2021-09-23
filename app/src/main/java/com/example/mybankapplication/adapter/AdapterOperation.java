package com.example.mybankapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.models.Operation;
import com.example.mybankapplication.viewHolder.CustomerViewHolder;
import com.example.mybankapplication.viewHolder.OperationViewHolder;

import java.util.ArrayList;

public class AdapterOperation extends RecyclerView.Adapter<OperationViewHolder> {
    private ArrayList<Operation> listOperationAdapter;

    public AdapterOperation(ArrayList<Operation> listOperationAdapter) {
        this.listOperationAdapter = listOperationAdapter;
    }

    public void setListOperationAdapter(ArrayList<Operation> listOperationAdapter) {
        this.listOperationAdapter = listOperationAdapter;
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.raw_operation,parent,false);
        return new OperationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        holder.bind(listOperationAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listOperationAdapter.size();
    }
}
