package com.example.tarea2_lista.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea2_lista.ListItem;
import com.example.tarea2_lista.R;

import java.util.List;

public class RecyclerAdapterTest extends RecyclerView.Adapter<RecyclerAdapterTest.TaskViewHolder> {

    private List<ListItem> tasks;

    public RecyclerAdapterTest(List<ListItem> tasks) {
        this.tasks = tasks;
    }


    @NonNull
    @Override
    public RecyclerAdapterTest.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item_layout, parent, false);

        return new RecyclerAdapterTest.TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTest.TaskViewHolder holder, int position) {

        holder.getTextView().setText(tasks.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{

        TextView textTask;
        ImageButton delete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            textTask = itemView.findViewById(R.id.textTask);
            delete = itemView.findViewById(R.id.buttonDelete);
        }

        public TextView getTextView() {
            return textTask;
        }
    }
}
