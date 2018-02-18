package com.example.croma.navigation_draw.Fragments;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.croma.navigation_draw.BuildConfig;
import com.example.croma.navigation_draw.MainActivity;
import com.example.croma.navigation_draw.NavigationManager;
import com.example.croma.navigation_draw.R;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Croma on 14-02-2018.
 */

public class FragmentNavigationManager  implements NavigationManager {
    private static FragmentNavigationManager sInstance;
    private FragmentManager mFragmentManager;
    private MainActivity mActivity;
    public static FragmentNavigationManager obtain(MainActivity activity){
        if(sInstance == null){
            sInstance = new FragmentNavigationManager();
        }
        sInstance.configure(activity);
        return sInstance;
    }

    private void configure(MainActivity activity){
        mActivity = activity;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }
 @Override
    public void showFragment1(String title) {
        showFragment(Fragment1.newInstance(title),false);
    }

    @Override
    public void showFragment2(String title) {
        showFragment(Fragment2.newInstance(title),false);
    }

    @Override
    public void showFragment3(String title) {
        showFragment(Fragment3.newInstance(title),false);
    }

    @Override
    public void showFragment4(String title) {
        showFragment(Fragment4.newInstance(title),false);
    }

    public void showFragment(Fragment fragment, boolean allowStateLoss){
//        if(fragment != null) {
//            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.game, fragment);
//            ft.commit();
//        }
        FragmentManager fm = mFragmentManager;
        @SuppressLint("commit Transaction")
        FragmentTransaction ft = fm.beginTransaction()
                .replace(R.id.container,fragment);
       // ft.addToBackStack(null);
//        if(allowStateLoss || !BuildConfig.DEBUG){
//            ft.commitAllowingStateLoss();
//        }else{
            ft.commit();
//        }
//        fm.executePendingTransactions();
    }
}
