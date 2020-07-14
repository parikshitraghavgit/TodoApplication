package com.symb.task.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class CreateTodoActivity extends AppCompatActivity {

    private EditText word;
    private Button btnSave;
    private String Paragraph;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        word = (EditText)findViewById(R.id.editText_word);
        btnSave = (Button)findViewById(R.id.button_save);
        databaseHelper = new DatabaseHelper(CreateTodoActivity.this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveMethod();
            }
        });


    }

    private void SaveMethod(){

        Paragraph = word.getText().toString();

        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(calendar.getTime());

        boolean IsInserted =  databaseHelper.insertData(Paragraph);
        if (IsInserted == true){
            Toast.makeText(CreateTodoActivity.this,"Data Inserted",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(CreateTodoActivity.this,"Data Not Inserted",
                    Toast.LENGTH_SHORT).show();
        }


    }

}
