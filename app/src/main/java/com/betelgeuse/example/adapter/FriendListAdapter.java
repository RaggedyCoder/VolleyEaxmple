package com.betelgeuse.example.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.betelgeuse.example.R;
import com.betelgeuse.example.api.domain.Friend;
import com.betelgeuse.example.api.domain.User;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {

    private List<Friend> friendList;
    private Activity activity;
    private LayoutInflater layoutInflater;
    private RequestManager requestManager;


    public FriendListAdapter(List<Friend> friendList, Activity activity) {
        this.friendList = friendList;
        this.activity = activity;
        requestManager = Glide.with(this.activity);
        layoutInflater = this.activity.getLayoutInflater();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.friend_list_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Friend friend = friendList.get(position);
        User user = friend.getUser();
        holder.fullNameTextView.setText(user.getFullName());
        int mutualFriends = friend.getMutualFriends();
        holder.mutualFriendCountTextView.setVisibility(friend.getMutualFriends() == 0 ? View.GONE : View.VISIBLE);
        holder.mutualFriendCountTextView.
                setText(activity.getResources().getQuantityString(R.plurals.mutual, mutualFriends, mutualFriends));
        requestManager.load(user.getProfilePictureUrl()).into(holder.profilePictureImageView);

    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RoundedImageView profilePictureImageView;

        private TextView fullNameTextView;

        private TextView mutualFriendCountTextView;

        ViewHolder(View itemView) {
            super(itemView);
            profilePictureImageView = findViewById(R.id.profile_picture_image_view);
            fullNameTextView = findViewById(R.id.full_name_text_view);
            fullNameTextView.setOnClickListener(this);
            mutualFriendCountTextView = findViewById(R.id.mutual_friend_count_text_view);
        }

        final <T extends View> T findViewById(int id) {
            return (T) itemView.findViewById(id);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.full_name_text_view:
                    Friend friend = friendList.get(getAdapterPosition());
                    User user = friend.getUser();
                    Toast.makeText(activity, user.getUsername(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
