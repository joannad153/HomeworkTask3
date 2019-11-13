package com.example.homeworktask3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SearchFragment extends Fragment {

    public Button button;
    public EditText input;
    public String inputString;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        button = view.findViewById(R.id.searchButton);
        input = (EditText) view.findViewById(R.id.textInput);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                inputString = input.getText().toString();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ResultsFragment fragment = new ResultsFragment();
                fragmentTransaction.hide(SearchFragment.this);

                Bundle bundle = new Bundle();
                bundle.putString("param1", inputString);
                fragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fragment_slot, fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }



}


