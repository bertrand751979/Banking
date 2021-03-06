package com.example.mybankapplication.viewHolder;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Customer;

public class CustomerViewHolder extends RecyclerView.ViewHolder {
    private TextView vhCustomerSurname;
    private TextView vhCustomerName;
    private TextView vhCustomerid;
    private  TextView vhCustomerAmount;

    public CustomerViewHolder(@NonNull View view) {
        super(view);
        vhCustomerSurname=view.findViewById(R.id.rawCustomerSurname);
        vhCustomerName=view.findViewById(R.id.rawCustomerName);
        vhCustomerid=view.findViewById(R.id.rawCustomerID);
        vhCustomerAmount=view.findViewById(R.id.rawCustomerAmount);
    }

    public TextView getVhCustomerSurname() {
        return vhCustomerSurname;
    }

    public void setVhCustomerSurname(TextView vhCustomerSurname) {
        this.vhCustomerSurname = vhCustomerSurname;
    }

    public TextView getVhCustomerName() {
        return vhCustomerName;
    }

    public void setVhCustomerName(TextView vhCustomerName) {
        this.vhCustomerName = vhCustomerName;
    }

    public TextView getVhCustomerid() {
        return vhCustomerid;
    }

    public void setVhCustomerid(TextView vhCustomerid) {
        this.vhCustomerid = vhCustomerid;
    }

    public TextView getVhCustomerAmount() {
        return vhCustomerAmount;
    }

    public void setVhCustomerAmount(TextView vhCustomerAmount) {
        this.vhCustomerAmount = vhCustomerAmount;
    }

    public void bind(Customer customer){
        vhCustomerSurname.setText(customer.getCustomerSurname());
        vhCustomerName.setText(customer.getCustomerName());
        vhCustomerid.setText(customer.getCustomerAccountNumber());
        vhCustomerAmount.setText(String.valueOf(customer.getCustomerAmount()));
    }
}
