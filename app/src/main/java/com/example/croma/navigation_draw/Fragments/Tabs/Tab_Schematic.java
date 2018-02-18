package com.example.croma.navigation_draw.Fragments.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croma.navigation_draw.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab_Schematic extends Fragment {


    public Tab_Schematic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View page3 =  inflater.inflate(R.layout.page2, container, false);
        return page3;
    }

}
