package com.betelgeuse.example.api;

import com.betelgeuse.example.api.domain.MetaData;
import com.betelgeuse.example.api.domain.NewsFeed;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsFeedData {

    @SerializedName("nf_list")
    private List<NewsFeed> newsFeedList;
    @SerializedName("meta_data")
    private MetaData metaData;

    public NewsFeedData() {
    }

    public NewsFeedData(List<NewsFeed> newsFeedList, MetaData metaData) {

        this.newsFeedList = newsFeedList;
        this.metaData = metaData;
    }

    public List<NewsFeed> getNewsFeedList() {

        return newsFeedList;
    }

    public void setNewsFeedList(List<NewsFeed> newsFeedList) {
        this.newsFeedList = newsFeedList;
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

        NewsFeedData that = (NewsFeedData) o;

        if (!newsFeedList.equals(that.newsFeedList)) return false;
        return metaData.equals(that.metaData);

    }

    @Override
    public int hashCode() {
        int result = newsFeedList.hashCode();
        result = 31 * result + metaData.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NewsFeedData{" +
                "newsFeedList=" + newsFeedList +
                ", metaData=" + metaData +
                '}';
    }
}
