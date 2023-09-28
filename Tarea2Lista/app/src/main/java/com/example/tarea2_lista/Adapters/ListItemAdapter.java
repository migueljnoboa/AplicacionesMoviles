package com.example.tarea2_lista.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea2_lista.ListItem;
import com.example.tarea2_lista.R;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter {


    public ListItemAdapter(@NonNull Context context, @NonNull ArrayList<ListItem> objects) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;
        ListItem currentListItem = (ListItem) getItem(position);

        // Obtener View
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item_layout, parent, false);
        }

        // Poner Texto
        TextView task = currentItemView.findViewById(R.id.textTask);
        assert currentListItem != null;
        task.setText(currentListItem.getText());

        ImageButton delete = currentItemView.findViewById(R.id.buttonDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(currentListItem);
            }
        });

        return currentItemView;
    }
}
