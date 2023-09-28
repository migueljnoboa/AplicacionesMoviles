package com.example.tarea2_lista;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tarea2_lista.Fragments.RecyclerFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new com.example.tarea2_lista.Fragments.ListFragment();
            case 1:
                return new RecyclerFragment();
            default:
                return new com.example.tarea2_lista.Fragments.ListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
