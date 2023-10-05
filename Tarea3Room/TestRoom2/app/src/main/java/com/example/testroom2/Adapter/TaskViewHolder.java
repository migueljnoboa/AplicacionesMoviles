package com.example.testroom2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testroom2.R;
import com.example.testroom2.data.Task;
import com.example.testroom2.data.TaskRepository;


public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TextView taskTextView;
    private final CheckBox taskCheckBox;
    private final ImageButton taskDelete;
    private TaskRepository repository;

    private TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        taskTextView = itemView.findViewById(R.id.textView);
        taskCheckBox = itemView.findViewById(R.id.checkBox);
        taskDelete = itemView.findViewById(R.id.buttonDelete);

    }

    public void bind(Task task){
        taskTextView.setText(task.getText());
        taskCheckBox.setChecked(task.isComplete());

    }

    static TaskViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);

        return new TaskViewHolder(view);
    }



}
