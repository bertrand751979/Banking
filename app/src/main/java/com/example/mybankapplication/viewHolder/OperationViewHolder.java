package com.example.mybankapplication.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Operation;

public class OperationViewHolder extends RecyclerView.ViewHolder {
    private TextView vhOperationdate;
    private TextView vhOperationamount;
    private TextView vhOperationAccountNumber;
    private TextView vhChoiceOperation;


    public OperationViewHolder(@NonNull View view) {
        super(view);
        vhOperationdate=view.findViewById(R.id.rawOperationDate);
        vhOperationamount=view.findViewById(R.id.rawAmountOperation);
        vhOperationAccountNumber=view.findViewById(R.id.rawOperationID);
        vhChoiceOperation=view.findViewById(R.id.rawChoiceOperation);
    }

    public TextView getVhOperationdate() {
        return vhOperationdate;
    }

    public void setVhOperationdate(TextView vhOperationdate) {
        this.vhOperationdate = vhOperationdate;
    }

    public TextView getVhOperationamount() {
        return vhOperationamount;
    }

    public void setVhOperationamount(TextView vhOperationamount) {
        this.vhOperationamount = vhOperationamount;
    }

    public TextView getVhOperationAccountNumber() {
        return vhOperationAccountNumber;
    }

    public void setVhOperationAccountNumber(TextView vhOperationAccountNumber) {
        this.vhOperationAccountNumber = vhOperationAccountNumber;
    }

    public TextView getVhChoiceOperation() {
        return vhChoiceOperation;
    }

    public void setVhChoiceOperation(TextView vhChoiceOperation) {
        this.vhChoiceOperation = vhChoiceOperation;
    }

    public void bind(Operation operation){
        vhOperationdate.setText(operation.getDate());
        vhOperationamount.setText(String.valueOf(operation.getAmount()));
        vhOperationAccountNumber.setText(operation.getOperationAccountNumber());
        vhChoiceOperation.setText(operation.getChoiceOperation());
    }
}
