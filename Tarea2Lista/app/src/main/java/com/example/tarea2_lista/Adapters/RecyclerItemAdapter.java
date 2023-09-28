package com.example.tarea2_lista.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea2_lista.ListItem;
import com.example.tarea2_lista.R;

import java.util.ArrayList;

public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.MyViewHolder> {

    private static ArrayList<ListItem> tasks;

    public RecyclerItemAdapter(ArrayList<ListItem> tasks) {
        this.tasks = tasks;
    }


    @NonNull
    @Override
    public RecyclerItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item_layout, parent, false);

        //return new RecyclerItemAdapter.MyViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemAdapter.MyViewHolder holder, int position) {

        //ListItem item = tasks.get(holder.getAdapterPosition());

        //holder.editTextTask.setText(item.getText());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView editTextTask;
        ImageView imageView;
        ImageButton buttonDelete;
        private Context context;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            editTextTask = itemView.findViewById(R.id.textTask);
            imageView = itemView.findViewById(R.id.imageDeleteBG);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            context = itemView.getContext();

            /*buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tasks.remove(getAdapterPosition());
                }
            });*/
        }
    }
}
