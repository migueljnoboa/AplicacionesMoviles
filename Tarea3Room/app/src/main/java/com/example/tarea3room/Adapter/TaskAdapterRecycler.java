package com.example.tarea3room.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea3room.Database.TaskRepository;
import com.example.tarea3room.Database.TaskViewModel;
import com.example.tarea3room.Entities.Task;
import com.example.tarea3room.R;

import java.util.List;

public class TaskAdapterRecycler extends RecyclerView.Adapter<TaskAdapterRecycler.TaskViewHolder> {

    private final LiveData<List<Task>> tasks;
    TaskViewModel taskViewModel;

    public TaskAdapterRecycler(LiveData<List<Task>> tasks, TaskViewModel taskViewModel) {
        this.tasks = tasks;
        this.taskViewModel = taskViewModel;
    }

    @NonNull
    @Override
    public TaskAdapterRecycler.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);

        return new TaskAdapterRecycler.TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapterRecycler.TaskViewHolder holder, int position) {

        Task task = tasks.getValue().get(position);

        holder.textTask.setText(task.getText());
        holder.complete.setChecked(task.isComplete());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskViewModel.delete(task);
            }
        });

        holder.complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setComplete(!task.isComplete());
                holder.complete.setChecked(task.isComplete());
            }
        });

    }

    @Override
    public int getItemCount() {

        return tasks.getValue().size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{

        CheckBox complete;
        TextView textTask;
        ImageButton deleteButton;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            complete = itemView.findViewById(R.id.completeCheckBox);
            textTask = itemView.findViewById(R.id.textTask);
            deleteButton = itemView.findViewById(R.id.btnDelete);

        }
    }
}
