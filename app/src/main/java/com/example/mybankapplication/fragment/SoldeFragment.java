package com.example.mybankapplication.fragment;

import static android.content.ContentValues.TAG;
import static com.example.mybankapplication.activities.EditCustomerActivity.myCustomerList;
import static com.example.mybankapplication.fragment.EditOperationFragment.myOperationList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybankapplication.R;
import com.example.mybankapplication.activities.EditCustomerActivity;
import com.example.mybankapplication.adapter.AdapterSolde;
import com.example.mybankapplication.models.Customer;
import com.example.mybankapplication.models.Operation;
import com.example.mybankapplication.models.Solde;
import java.util.ArrayList;

public class SoldeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Solde>mySoldeList=new ArrayList<>();
    private AdapterSolde soldeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_solde,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerViewListSolde);
        setViewItem();

    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(SoldeFragment.this.getContext()));
        soldeAdapter=new AdapterSolde(mySoldeList);
        recyclerView.setAdapter(soldeAdapter);
    }





}

