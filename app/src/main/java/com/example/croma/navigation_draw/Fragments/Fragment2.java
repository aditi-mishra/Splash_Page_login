package com.example.croma.navigation_draw.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croma.navigation_draw.R;

public class Fragment2 extends Fragment {
    private static final String head = "Experiment 2";
    public static Fragment2 newInstance(String Title){
        Fragment2  frag = new Fragment2();
        Bundle args = new Bundle();
        args.putString(head, Title);
        frag.setArguments(args);
        return frag;
    }
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

}
