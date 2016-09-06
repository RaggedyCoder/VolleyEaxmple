package com.betelgeuse.example.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.betelgeuse.example.R;
import com.betelgeuse.example.activity.SwitchFragmentListener;

public class NavigationDrawerFragment extends AppFragment<NavigationDrawerFragment.ViewHolder> implements NavigationView.OnNavigationItemSelectedListener {


    private SwitchFragmentListener switchFragmentListener;

    @Override
    ViewHolder onCreateViewHolder(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        switchFragmentListener = (SwitchFragmentListener) getActivity();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_news_feed:
                return switchFragmentListener.changeFragment(0);
            case R.id.nav_friend_list:
                return switchFragmentListener.changeFragment(1);
            default:
                return false;
        }
    }


    class ViewHolder extends AppFragment.ViewHolder {

        private NavigationView navigationView;

        ViewHolder(View rootView) {
            super(rootView);
            navigationView = findViewById(R.id.nav_view);
            navigationView.setCheckedItem(R.id.nav_news_feed);
            navigationView.setNavigationItemSelectedListener(NavigationDrawerFragment.this);
        }
    }
}
