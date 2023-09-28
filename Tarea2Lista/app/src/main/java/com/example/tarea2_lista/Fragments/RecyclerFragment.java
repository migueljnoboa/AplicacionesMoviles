package com.example.tarea2_lista.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tarea2_lista.Adapters.RecyclerAdapterTest;
import com.example.tarea2_lista.ListItem;
import com.example.tarea2_lista.R;
import com.example.tarea2_lista.Adapters.RecyclerItemAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private EditText editAddTask;
    private ImageButton buttonAdd;
    private RecyclerView recyclerView;
    private RecyclerItemAdapter recyclerItemAdapter;
    private ArrayList<ListItem> arraytasks = new ArrayList<>();

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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

        view = inflater.inflate(R.layout.fragment_recycler, container, false);

        editAddTask = view.findViewById(R.id.editAddText);
        buttonAdd = view.findViewById(R.id.addButton);
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        RecyclerAdapterTest adapter = new RecyclerAdapterTest(arraytasks);
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editAddTask.getText().toString();
                if (!text.equalsIgnoreCase("")){
                    arraytasks.add(new ListItem(text));
                    editAddTask.setText("");
                    adapter.notifyItemInserted(arraytasks.size()-1);
                }
            }
        });


        // Inflate the layout for this fragment
        return view;


    }
}