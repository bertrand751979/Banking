package com.example.mybankapplication.viewHolder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Solde;

public class SoldeViewHolder extends RecyclerView.ViewHolder {
    private TextView vhSoldeCustomerNumber;
    private TextView vhSoldeOperation;


    public SoldeViewHolder(@NonNull View view) {
        super(view);
        vhSoldeCustomerNumber=view.findViewById(R.id.rawSoldeCustomerNumber);
        vhSoldeOperation=view.findViewById(R.id.rawSoldeAmount);
    }

    public TextView getVhSoldeCustomerNumber() {
        return vhSoldeCustomerNumber;
    }

    public void setVhSoldeCustomerNumber(TextView vhSoldeCustomerNumber) {
        this.vhSoldeCustomerNumber = vhSoldeCustomerNumber;
    }

    public TextView getVhSoldeOperation() {
        return vhSoldeOperation;
    }

    public void setVhSoldeOperation(TextView vhSoldeOperation) {
        this.vhSoldeOperation = vhSoldeOperation;
    }
    public void bind(Solde solde){
        vhSoldeCustomerNumber.setText(solde.getSoldeCustomerNumber());
        vhSoldeOperation.setText(String.valueOf(solde.getSoldeOperation()));
    }
}
