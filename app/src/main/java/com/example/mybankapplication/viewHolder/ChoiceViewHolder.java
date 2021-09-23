package com.example.mybankapplication.viewHolder;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Choice;

public class ChoiceViewHolder extends RecyclerView.ViewHolder {
    private TextView vhSpinnerEdit;

    public ChoiceViewHolder(@NonNull View view) {
        super(view);
        vhSpinnerEdit=view.findViewById(R.id.raw_spinner_choice);
    }

    public TextView getVhSpinnerEdit() {
        return vhSpinnerEdit;
    }

    public void setVhSpinnerEdit(TextView vhSpinnerEdit) {
        this.vhSpinnerEdit = vhSpinnerEdit;
    }

    public void bind(Choice choice){
        vhSpinnerEdit.setText(choice.getChoiceSerlected());

    }
}
