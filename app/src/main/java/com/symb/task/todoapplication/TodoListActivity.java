package com.symb.task.todoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class TodoListActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        databaseHelper = new DatabaseHelper(TodoListActivity.this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        viewAll();
    }

    private void viewAll(){
        Cursor res = databaseHelper.getAllData();
        if (res.getCount()==0){
            Toast.makeText(TodoListActivity.this,"Error! No data found",Toast.LENGTH_LONG).show();
            return;
        }
        int StringArraySize = res.getCount();
        String[] stringArray =new String[StringArraySize];
        String[] stringArrayDate =new String[StringArraySize];

        int i = 0;
        while (res.moveToNext()){
            stringArray[i]=res.getString(1);
            stringArrayDate[i]=res.getString(2);
            i++;
        }

        recyclerAdapter = new RecyclerAdapter(this,stringArray,stringArrayDate);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerAdapter);

    }

}
