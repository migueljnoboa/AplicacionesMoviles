package com.example.testroom2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.testroom2.R;
import com.example.testroom2.data.Task;
import com.example.testroom2.data.TaskRepository;

import java.util.function.Consumer;

public class TaskListAdapter extends ListAdapter<Task, TaskViewHolder> {

    private Consumer<Task> taskConsumer;
    private TaskRepository repository;

    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, TaskRepository repository) {

        super(diffCallback);
        this.repository = repository;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);

    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task current = getItem(position);
        holder.bind(current);

        CheckBox checkBox = holder.itemView.findViewById(R.id.checkBox);
        ImageButton deletebtn = holder.itemView.findViewById(R.id.buttonDelete);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current.setComplete(!current.isComplete());
                checkBox.setChecked(!current.isComplete());
                repository.update(current);
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repository.delete(current);
            }
        });

    }

    public static class TaskDiff extends DiffUtil.ItemCallback<Task>{

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getText().equals(newItem.getText()) &&
                    oldItem.isComplete() == newItem.isComplete();
        }
    }
}
