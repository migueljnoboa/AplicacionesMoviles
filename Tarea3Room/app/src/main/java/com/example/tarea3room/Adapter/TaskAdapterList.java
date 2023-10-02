package com.example.tarea3room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tarea3room.Entities.Task;
import com.example.tarea3room.R;

import java.util.ArrayList;

public class TaskAdapterList extends ArrayAdapter {
    public TaskAdapterList(@NonNull Context context, ArrayList<Task> objets) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;
        Task currenttask = (Task) getItem(position);

        if (currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item_layout, parent, false);
        }

        TextView textTask = currentItemView.findViewById(R.id.textTask);
        currenttask.setText(currenttask.getText());

        ImageButton delete = currentItemView.findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(currenttask);
            }
        });

        return currentItemView;
    }
}
