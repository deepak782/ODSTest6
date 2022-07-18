package com.example.odstest6.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.odstest6.MainActivity;
import com.example.odstest6.R;

public class ListFragment extends Fragment {

    ListView listView;
    String[] names={"Android Java","Android Kotlin","Android Compose","IOS","Web Front End","Web Back End"};
    ArrayAdapter<String> arrayAdapter;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_list, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.simple_List);
        arrayAdapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // startActivity(new Intent(getActivity(), MainActivity.class));

                fragment=new ViewListFragment();
                fragmentManager=getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container2,fragment);
                fragmentTransaction.commit();
            }
        });
    }
}