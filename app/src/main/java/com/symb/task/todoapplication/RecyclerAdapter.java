package com.symb.task.todoapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass> {

    Context context;String[] strings;
    String[] stringsDate;

    public RecyclerAdapter(Context context, String[] strings,String[] stringsDate) {
        this.context = context;
        this.strings = strings;
        this.stringsDate = stringsDate;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolderClass(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {

        String content = strings[position];
        holder.textView.setText(content);

        String date = stringsDate[position];
        holder.textViewDate.setText(date);

    }

    @Override
    public int getItemCount() {
        if (strings.length==0){
            return 0;
        }else
            return strings.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        private TextView textView,textViewDate;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView)itemView.findViewById(R.id.textView);
            this.textViewDate = (TextView)itemView.findViewById(R.id.textViewDate);
        }
    }
}