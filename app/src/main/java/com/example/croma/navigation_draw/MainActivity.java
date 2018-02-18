package com.example.croma.navigation_draw;

//import android.app.Fragment;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.croma.navigation_draw.Fragments.Fragment1;
import com.example.croma.navigation_draw.Fragments.Fragment2;
import com.example.croma.navigation_draw.Fragments.Fragment3;
import com.example.croma.navigation_draw.Fragments.Fragment4;
import com.example.croma.navigation_draw.Fragments.FragmentNavigationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
         Fragment a = null;
        if (id == R.id.exp_1) {
            // Handle the camera action
            a = new Fragment1();
        } else if (id == R.id.exp_2) {
           a = new Fragment2();
        } else if (id == R.id.exp_3) {
           a = new Fragment3();
        } else if (id == R.id.exp4) {
          a = new Fragment4();
        }
        if(a != null){
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.game,a);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

/*
public class MainActivity extends AppCompatActivity{
    public static final String TAG =" error ";
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;
    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapter;
    private List<String> mExpandableListTitle;
    private FragmentNavigationManager mNavigationManager;
    private Map<String, List<String>> mExpandableListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //from here
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // to here....:)
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle =getTitle().toString();
        mExpandableListView =(ExpandableListView) findViewById(R.id.navList);
        mNavigationManager = FragmentNavigationManager.obtain(this);

        initItems();
        LayoutInflater inflater = getLayoutInflater();
        View listHeaderView = inflater.inflate(R.layout.nav_header_main,null,false);
      //  mExpandableListView.addHeaderView(listHeaderView);

        mExpandableListData = ExpandableListDataSource.getData();
        mExpandableListTitle = new ArrayList<>(mExpandableListData.keySet());
        addDrawerItems();
        setupDrawer();
//        if(savedInstanceState == null){
//            selectFirstItemAsDefault();
//        }
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setHomeButtonEnabled(true);


    }
    private void selectFirstItemAsDefault(){
        if(mNavigationManager != null){
            String first = "Experiment 1";
            mNavigationManager.showFragment1(first);
       ///     getSupportActionBar().setTitle(first);
        }
    }
    private void initItems(){
        items = getResources().getStringArray(R.array.exp_names);
    }

    private void addDrawerItems() {
        mExpandableListAdapter = new CustomExpandableListAdapter(this,
                mExpandableListTitle, mExpandableListData);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        mExpandableListView.setOnGroupExpandListener(new
                                                             ExpandableListView.OnGroupExpandListener() {
                                                                 @Override
                                                                 public void onGroupExpand(int groupPosition) {
                                                                 //   getSupportActionBar().setTitle(mExpandableListTitle.get(groupPosition).toString());
                                                                 }
                                                             });

        mExpandableListView.setOnGroupCollapseListener(new
                                                               ExpandableListView.OnGroupCollapseListener() {
                                                                   @Override
                                                                   public void onGroupCollapse(int groupPosition) {
                                                                    //  getSupportActionBar().setTitle(R.string.exp_name);
                                                                   }
                                                               });

        mExpandableListView.setOnChildClickListener(new
                                                            ExpandableListView.OnChildClickListener() {
                                                                @Override
                                                                public boolean onChildClick(ExpandableListView parent, View v,
                                                                                            int groupPosition, int childPosition, long id) {
                                                                    String selectedItem = ((List)
                                                                            (mExpandableListData.get(mExpandableListTitle.get(groupPosition))))
                                                                            .get(childPosition).toString();
                                                                  //  getSupportActionBar().setTitle(selectedItem);
                                                                    Log.d(TAG,selectedItem);

                                                                    if (items[0].equals(mExpandableListTitle.get(groupPosition))) {
                                                                        mNavigationManager.showFragment1(selectedItem);
                                                                    } else if (items[1].equals(mExpandableListTitle.get(groupPosition))) {
                                                                        mNavigationManager.showFragment2(selectedItem);
                                                                    } else if (items[2].equals(mExpandableListTitle.get(groupPosition))) {
                                                                        mNavigationManager.showFragment3(selectedItem);
//                                                                    } else if (items[3].equals(mExpandableListTitle.get(groupPosition))) {
//                                                                        mNavigationManager.showFragment4(selectedItem);
//                                                                    } else if (items[4].equals(mExpandableListTitle.get(groupPosition))) {
//                                                                        mNavigationManager.showFragmentThriller(selectedItem);
                                                                    } else {
                                                                        mNavigationManager.showFragment1(selectedItem);
                                                                        Log.d(TAG,"Wrong !!");
                                                                      //  throw new IllegalArgumentException("Not supported fragment type");
                                                                    }

                                                                    mDrawerLayout.closeDrawer(GravityCompat.START);
                                                                    return false;
                                                                }
                                                            });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /* Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.exp_name);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
*/
            /** Called when a drawer has settled in a completely closed state. */
//            public void onDrawerClosed(View view) {
//                super.onDrawerClosed(view);
//                getSupportActionBar().setTitle(mActivityTitle);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
//            }
//        };
//
//        mDrawerToggle.setDrawerIndicatorEnabled(true);
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//// Sync the toggle state after onRestoreInstanceState has occurred.
//        mDrawerToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//// Handle action bar item clicks here. The action bar will
//// automatically handle clicks on the Home/Up button, so long
//// as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//// Activate the navigation drawer toggle
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
////    private void initItems(){
////        items = getResources().getStringArray()
////    }
//}
