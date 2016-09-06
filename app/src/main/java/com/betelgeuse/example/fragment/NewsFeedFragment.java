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
import com.betelgeuse.example.adapter.NewsFeedAdapter;
import com.betelgeuse.example.api.NewsFeedData;
import com.betelgeuse.example.api.domain.NewsFeed;
import com.betelgeuse.example.application.ExampleApplication;
import com.betelgeuse.example.toolbox.ObjectRequest;
import com.betelgeuse.example.util.API;
import com.betelgeuse.example.view.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedFragment extends AppFragment<NewsFeedFragment.ViewHolder> implements RecyclerView.OnItemClickListener, Response.Listener<NewsFeedData>, Response.ErrorListener {

    private NewsFeedAdapter newsFeedAdapter;
    private List<NewsFeed> newsFeedList;
    private ObjectRequest<NewsFeedData> newsFeedDataObjectRequest;
    private ExampleApplication exampleApplication = ExampleApplication.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsFeedList = new ArrayList<>();
        newsFeedAdapter = new NewsFeedAdapter(newsFeedList, getActivity());
    }

    @Override
    ViewHolder onCreateViewHolder(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        newsFeedDataObjectRequest = new ObjectRequest<>(Request.Method.GET, API.NEWS_FEED_LIST, this, this, NewsFeedData.class);
        exampleApplication.addToRequestQueue(newsFeedDataObjectRequest);
    }

    @Override
    public boolean onItemClick(View clickedItemView, int position, long id) {
        return false;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(NewsFeedData newsFeedData) {
        newsFeedList.clear();
        newsFeedList.addAll(newsFeedData.getNewsFeedList());
        newsFeedAdapter.notifyDataSetChanged();
    }


    class ViewHolder extends AppFragment.ViewHolder {

        private RecyclerView newsFeedRecyclerView;

        ViewHolder(View rootView) {
            super(rootView);
            newsFeedRecyclerView = findViewById(R.id.news_feed_recycler_view);
            initializeRecyclerView();
        }

        private void initializeRecyclerView() {
            newsFeedRecyclerView.setAsListType(RecyclerView.VERTICAL_LAYOUT);
            newsFeedRecyclerView.setAdapter(newsFeedAdapter);
            newsFeedRecyclerView.setOnItemClickListener(NewsFeedFragment.this);
        }
    }
}
