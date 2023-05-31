package com.example.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private EditText edtLength, edtWidth, edtHeight;
    private Button btnCalculate;
    private TextView tvResult;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        edtWidth = findViewById(R.id.edt_width);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String length = edtLength.getText().toString();
                String width = edtWidth.getText().toString();
                String height = edtHeight.getText().toString();

                if (length.isEmpty()){
                    edtWidth.setError("Please enter length");
                } else if (width.isEmpty()){
                    edtHeight.setError("Please enter width");
                } else if (height.isEmpty()) {
                    edtLength.setError("Please enter height");
                } else {
//                    calculate(length, width, height);
                    viewModel.calculate(length, width, height);
                }
            }
        });
        displayResult();
    }

    private void calculate(String length, String width, String height) {
        String result =
                String.valueOf(Integer.parseInt(width)
                * Integer.parseInt(height)
                * Integer.parseInt(length));
        tvResult.setText(result);
    }

    private void displayResult(){
     viewModel.result.observe(this, new Observer<Integer>(){
         @Override
         public void onChanged(Integer result) {
             tvResult.setText(String.valueOf(result));
         }
     });
    }
}