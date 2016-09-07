package com.betelgeuse.example.api;

import com.betelgeuse.example.api.domain.Friend;
import com.betelgeuse.example.api.domain.MetaData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendListData {

    @SerializedName("f_list")
    private List<Friend> friendList;
    @SerializedName("meta_data")
    private MetaData metaData;

    public FriendListData() {
    }

    public FriendListData(List<Friend> friendList, MetaData metaData) {

        this.friendList = friendList;
        this.metaData = metaData;
    }

    public List<Friend> getFriendList() {

        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendListData that = (FriendListData) o;

        if (!friendList.equals(that.friendList)) return false;
        return metaData.equals(that.metaData);

    }

    @Override
    public int hashCode() {
        int result = friendList.hashCode();
        result = 31 * result + metaData.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NewsFeedData{" +
                "friendList=" + friendList +
                ", metaData=" + metaData +
                '}';
    }
}
