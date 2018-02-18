package com.example.croma.navigation_draw.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;

import com.example.croma.navigation_draw.Fragments.Tabs.Tab_Introduction;
import com.example.croma.navigation_draw.Fragments.Tabs.Tab_Schematic;
import com.example.croma.navigation_draw.Fragments.Tabs.Tab_code;
import com.example.croma.navigation_draw.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment4 extends Fragment {
    private static final String head = "Experiment 4";
    public static Fragment4 newInstance(String Title){
        Fragment4  frag = new Fragment4();
        Bundle args = new Bundle();
        args.putString(head, Title);
        frag.setArguments(args);
        return frag;
    }
      String TAG ="hey";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }



    public void setupViewPager(ViewPager viewpage){
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new Tab_Introduction(), "Introduction");
        adapter.addFragment(new Tab_Schematic(), "Schematic");
        adapter.addFragment(new Tab_code(), "Code");

        viewpage.setAdapter(adapter);

    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);
        return view;
    }
}
