package com.betelgeuse.example.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.betelgeuse.example.R;
import com.betelgeuse.example.api.domain.NewsFeed;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    private static final int PICTURE = 1;
    private static final int STATUS = 0;

    private List<NewsFeed> newsFeedList;
    private Activity activity;
    private LayoutInflater layoutInflater;
    private RequestManager requestManager;


    public NewsFeedAdapter(List<NewsFeed> newsFeedList, Activity activity) {
        this.newsFeedList = newsFeedList;
        this.activity = activity;
        requestManager = Glide.with(this.activity);
        layoutInflater = this.activity.getLayoutInflater();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        switch (viewType) {
            case PICTURE:
                rootView = layoutInflater.inflate(R.layout.news_feed_picture, parent, false);
                break;
            case STATUS:
            default:
                rootView = layoutInflater.inflate(R.layout.news_feed_status, parent, false);
                break;

        }
        return new ViewHolder(rootView);
    }

    @Override
    public int getItemViewType(int position) {
        return newsFeedList.get(position).getNewsType();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        NewsFeed newsFeed = newsFeedList.get(position);
        holder.fullNameTextView.setText(newsFeed.getFullName());
        holder.statusTextView.setText(newsFeed.getStatus());
        requestManager.load(newsFeed.getProfilePictureUrl()).into(holder.profilePictureImageView);
        if (newsFeed.getNewsType() == PICTURE) {
            requestManager.load(newsFeed.getImageUrl()).into(holder.pictureImageView);
        }
        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
                newsFeed.getTimestamp(), System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
        holder.timestampTextView.setText(timeAgo);
    }

    @Override
    public int getItemCount() {
        return newsFeedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RoundedImageView profilePictureImageView;

        private TextView fullNameTextView;

        private TextView timestampTextView;

        private TextView statusTextView;

        private ImageView pictureImageView;

        ViewHolder(View itemView) {
            super(itemView);
            profilePictureImageView = findViewById(R.id.profile_picture_image_view);
            fullNameTextView = findViewById(R.id.full_name_text_view);
            fullNameTextView.setOnClickListener(this);
            timestampTextView = findViewById(R.id.timestamp_text_view);
            statusTextView = findViewById(R.id.status_text_view);
            pictureImageView = findViewById(R.id.picture_image_view);
        }

        final <T extends View> T findViewById(int id) {
            return (T) itemView.findViewById(id);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.full_name_text_view:
                    NewsFeed newsFeed = newsFeedList.get(getAdapterPosition());
                    Toast.makeText(activity, newsFeed.getUsername(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
