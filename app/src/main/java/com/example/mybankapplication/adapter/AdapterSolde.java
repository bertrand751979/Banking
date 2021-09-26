package com.example.mybankapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybankapplication.R;
import com.example.mybankapplication.models.Solde;
import com.example.mybankapplication.viewHolder.OperationViewHolder;
import com.example.mybankapplication.viewHolder.SoldeViewHolder;
import java.util.ArrayList;

public class AdapterSolde extends RecyclerView.Adapter<SoldeViewHolder> {
    private ArrayList<Solde>listAdapterSolde;

    public AdapterSolde(ArrayList<Solde> listAdapterSolde) {
        this.listAdapterSolde = listAdapterSolde;
    }

    public void setListAdapterSolde(ArrayList<Solde> listAdapterSolde) {
        this.listAdapterSolde = listAdapterSolde;
    }

    @NonNull
    @Override
    public SoldeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.raw_customer,parent,false);
        return new SoldeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoldeViewHolder holder, int position) {
    holder.bind(listAdapterSolde.get(position));
    }

    @Override
    public int getItemCount() {
        return listAdapterSolde.size();
    }
}
