package com.example.mybankapplication.fragment;

import static com.example.mybankapplication.activities.MainActivity.MY_CHOICE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_OPERATION_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.adapter.AdapterOperation;
import com.example.mybankapplication.models.Choice;
import com.example.mybankapplication.models.Operation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DisplayOperationFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterOperation operationAdapter;
    private ArrayList<Operation> myOperationList=new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myOperationList=new ArrayList<Operation>(SharedPreferencesManager.getInstance(DisplayOperationFragment.this.getContext()).getOperation(MY_OPERATION_KEY));

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_operation,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewListOperation);
        setViewItem();
    }
    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayOperationFragment.this.getContext()));
        operationAdapter=new AdapterOperation(myOperationList);
        recyclerView.setAdapter(operationAdapter);
    }



}
