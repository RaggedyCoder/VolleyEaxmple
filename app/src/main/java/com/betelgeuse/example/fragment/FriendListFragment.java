package com.betelgeuse.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.betelgeuse.example.R;
import com.betelgeuse.example.adapter.FriendListAdapter;
import com.betelgeuse.example.api.FriendListData;
import com.betelgeuse.example.api.domain.Friend;
import com.betelgeuse.example.application.ExampleApplication;
import com.betelgeuse.example.toolbox.ObjectRequest;
import com.betelgeuse.example.util.API;
import com.betelgeuse.example.view.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends AppFragment<FriendListFragment.ViewHolder> implements RecyclerView.OnItemClickListener, Response.Listener<FriendListData>, Response.ErrorListener {

    private FriendListAdapter newsFeedAdapter;
    private List<Friend> newsFeedList;
    private ObjectRequest<FriendListData> friendListDataObjectRequest;
    private ExampleApplication exampleApplication = ExampleApplication.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsFeedList = new ArrayList<>();
        newsFeedAdapter = new FriendListAdapter(newsFeedList, getActivity());
    }

    @Override
    ViewHolder onCreateViewHolder(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_single_list, container, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        friendListDataObjectRequest = new ObjectRequest<>(Request.Method.GET, API.FRIEND_LIST, this, this, FriendListData.class);
        exampleApplication.addToRequestQueue(friendListDataObjectRequest);
    }

    @Override
    public boolean onItemClick(View clickedItemView, int position, long id) {
        return false;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(FriendListData friendListData) {
        newsFeedList.clear();
        newsFeedList.addAll(friendListData.getFriendList());
        newsFeedAdapter.notifyDataSetChanged();
    }


    class ViewHolder extends AppFragment.ViewHolder {

        private RecyclerView recyclerView;

        ViewHolder(View rootView) {
            super(rootView);
            recyclerView = findViewById(R.id.recycler_view);
            initializeRecyclerView();
        }

        private void initializeRecyclerView() {
            recyclerView.setAsGridType(2);
            recyclerView.setAdapter(newsFeedAdapter);
            recyclerView.setOnItemClickListener(FriendListFragment.this);
        }
    }
}
