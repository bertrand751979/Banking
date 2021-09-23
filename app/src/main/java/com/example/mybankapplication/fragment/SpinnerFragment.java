package com.example.mybankapplication.fragment;

import static com.example.mybankapplication.activities.MainActivity.MY_CHOICE_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.adapter.AdapterChoice;
import com.example.mybankapplication.models.Choice;

import java.util.ArrayList;

public class SpinnerFragment extends Fragment {
    private ArrayList<Choice>myChoiceList=new ArrayList<>();
    private EditText editSpinner;
    private Button btnSaveSpinnerChoice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferencesManager.getInstance(SpinnerFragment.this.getContext()).getChoice( MY_CHOICE_KEY);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.activity_edit_spinner_content,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editSpinner=view.findViewById(R.id.editChoiceSpinner);
        btnSaveSpinnerChoice=view.findViewById(R.id.btnValidChoice);
        btnSaveSpinnerChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSpinnerChoice();
            }
        });

    }

    private void addSpinnerChoice(){
        Choice choice=new Choice();
        choice.setChoiceSerlected(editSpinner.getText().toString());
        myChoiceList.add(choice);
        SharedPreferencesManager.getInstance(SpinnerFragment.this.getContext()).saveChoice(myChoiceList, MY_CHOICE_KEY);
        Toast.makeText(SpinnerFragment.this.getContext(), "la taille de la liste est:"+myChoiceList.size(), Toast.LENGTH_SHORT).show();
    }





}
