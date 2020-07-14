package com.symb.task.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonUi extends AppCompatActivity {
Button btnTodo,btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_ui);
    btnTodo = (Button)findViewById(R.id.buttonCreateTodo);
        btnList = (Button)findViewById(R.id.buttonTodoList);

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ButtonUi.this,CreateTodoActivity.class);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ButtonUi.this,TodoListActivity.class);
                startActivity(intent);
            }
        });

    }
}
