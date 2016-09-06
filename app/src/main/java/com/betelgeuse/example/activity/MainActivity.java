package com.betelgeuse.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.betelgeuse.example.R;
import com.betelgeuse.example.fragment.NewsFeedFragment;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements SwitchFragmentListener {

    /**
     * This static {@link String} just needed for the {@link Log} trace.
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout mainAppDrawerLayout;

    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawerLayout();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new NewsFeedFragment()).commit();
    }

    private void initDrawerLayout() {
        mainAppDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new DrawerToggle(this, mainAppDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mainAppDrawerLayout.addDrawerListener(actionBarDrawerToggle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu(Menu menu)");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onPostCreate(Bundle savedInstanceState)");
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected(MenuItem item)");
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean changeFragment(int fragmentId) {
        Log.d(TAG, "changeFragment(int fragmentId)");
        mainAppDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    class DrawerToggle extends ActionBarDrawerToggle {

        DrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int openDrawerContentDescRes, @StringRes int closeDrawerContentDescRes) {
            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            Log.d(TAG, "onDrawerOpened(View drawerView)");
            super.onDrawerOpened(drawerView);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            Log.d(TAG, "onDrawerClosed(View drawerView)");
            super.onDrawerClosed(drawerView);
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            Log.d(TAG, "onDrawerClosed(View drawerView, float slideOffset) slideOffset = " + slideOffset);
            super.onDrawerSlide(drawerView, slideOffset);
        }
    }
}
