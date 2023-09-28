package com.example.tarea2_lista;

import android.widget.ImageButton;

public class ListItem {

    private String Text;

    public ListItem(String text) {
        Text = text;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
