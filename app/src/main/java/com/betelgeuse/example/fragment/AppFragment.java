package com.betelgeuse.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract class AppFragment<T extends AppFragment.ViewHolder> extends Fragment {

    private T viewHolder;


    public AppFragment() {
        super();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract T onCreateViewHolder(LayoutInflater inflater, @Nullable ViewGroup container);

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewHolder = onCreateViewHolder(inflater, container);

        return viewHolder.rootView;
    }

    public T getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(T viewHolder) {
        this.viewHolder = viewHolder;
    }

    static abstract class ViewHolder {

        final View rootView;

        ViewHolder(View rootView) {
            this.rootView = rootView;
        }

        final <T extends View> T findViewById(int id) {
            return (T) rootView.findViewById(id);
        }
    }


}
