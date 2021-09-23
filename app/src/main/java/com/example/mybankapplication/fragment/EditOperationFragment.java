package com.example.mybankapplication.fragment;

import static com.example.mybankapplication.activities.MainActivity.MY_CHOICE_KEY;
import static com.example.mybankapplication.activities.MainActivity.MY_OPERATION_KEY;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mybankapplication.R;
import com.example.mybankapplication.SharedPreferencesManager;
import com.example.mybankapplication.models.Choice;
import com.example.mybankapplication.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class EditOperationFragment extends Fragment {
    private TextView date;
    private EditText amount;
    private EditText operationAccountNumber;
    private TextView choiceOperation;
    private Button btnSelectedDate;
    private Button btnSaveOperation;
    private int selectedYear=2021;
    private int selectedMonth=1;
    private int selectedDay=1;
    private String operationSelected;
    private ArrayList<Operation>myOperationList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_edit_operation,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date=view.findViewById(R.id.displayOperation_date);
        amount=view.findViewById(R.id.displayOperation_edit_amount);
        operationAccountNumber=view.findViewById(R.id.displayOperation_edit_Id);
        choiceOperation=view.findViewById(R.id.displayOperationChoixDeRetraitOuDepot);
        btnSaveOperation=view.findViewById(R.id.btnSaveOperation);
        btnSaveOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation();
            }
        });
        btnSelectedDate=view.findViewById(R.id.btnSelectDate);
        btnSelectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        date.setText("Le " + day + " - " + (month + 1) + "- " + year);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditOperationFragment.this.getContext(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar, dateSetListener, selectedYear, selectedMonth, selectedDay);
                datePickerDialog.show();
            }
        });

        List<Choice> listRoom= SharedPreferencesManager.getInstance(EditOperationFragment.this.getContext()).getChoice(MY_CHOICE_KEY);
        Spinner spinner=view.findViewById(R.id.spinner1);
        //1 ADapter,Layout et une list
        ArrayAdapter<Choice> adapter = new ArrayAdapter<Choice>(EditOperationFragment.this.getContext(),android.R.layout.simple_spinner_item,listRoom);
        //ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.room, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                Choice choice = (Choice) adapter.getItem(i);
                operationSelected=choice.getChoiceSerlected();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addOperation(){
        Operation operation=new Operation();
        operation.setOperationAccountNumber(operationAccountNumber.getText().toString());
        operation.setAmount(Double.valueOf(amount.getText().toString()));
        operation.setChoiceOperation(operationSelected);
        operation.setDate(date.getText().toString());
        myOperationList.add(operation);
        SharedPreferencesManager.getInstance(EditOperationFragment.this.getContext()).saveOperation(myOperationList, MY_OPERATION_KEY);
        Toast.makeText(EditOperationFragment.this.getContext(),"La taille de la liste est: "+myOperationList.size(),Toast.LENGTH_SHORT).show();
    }


}
