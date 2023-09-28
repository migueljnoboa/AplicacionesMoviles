package com.example.tarea2_lista.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarea2_lista.ListItem;
import com.example.tarea2_lista.ListItemAdapter;
import com.example.tarea2_lista.R;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText editAddTask;
    private ImageButton buttonAdd;
    private ListView listView;
    private ArrayList<ListItem> arraytasks = new ArrayList<>();
    private ListItemAdapter listItemAdapter;
    private View view;


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // getting view from inflater
        view = inflater.inflate(R.layout.fragment_list, container, false);

        // setting variables
        editAddTask = view.findViewById(R.id.editAddText);
        buttonAdd = view.findViewById(R.id.addButton);
        listView = view.findViewById(R.id.listView);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editAddTask.getText().toString();
                if (!text.equalsIgnoreCase("")){
                    listItemAdapter.add(new ListItem(text));
                    editAddTask.setText("");
                }
            }
        });

        listItemAdapter = new ListItemAdapter(view.getContext(), arraytasks);
        listView.setAdapter(listItemAdapter);

        return view;

    }

}