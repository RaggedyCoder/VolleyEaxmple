package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

public class MetaData {
    @SerializedName("total_feed")
    private int totalFeed;
    @SerializedName("p_feeds")
    private String previousFeeds;
    @SerializedName("n_feeds")
    private String nextFeeds;

    public MetaData() {
    }

    public MetaData(int totalFeed, String previousFeeds, String nextFeeds) {

        this.totalFeed = totalFeed;
        this.previousFeeds = previousFeeds;
        this.nextFeeds = nextFeeds;
    }

    public int getTotalFeed() {

        return totalFeed;
    }

    public void setTotalFeed(int totalFeed) {
        this.totalFeed = totalFeed;
    }

    public String getPreviousFeeds() {
        return previousFeeds;
    }

    public void setPreviousFeeds(String previousFeeds) {
        this.previousFeeds = previousFeeds;
    }

    public String getNextFeeds() {
        return nextFeeds;
    }

    public void setNextFeeds(String nextFeeds) {
        this.nextFeeds = nextFeeds;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaData metaData = (MetaData) o;

        if (totalFeed != metaData.totalFeed) return false;
        if (!previousFeeds.equals(metaData.previousFeeds)) return false;
        return nextFeeds.equals(metaData.nextFeeds);

    }

    @Override
    public int hashCode() {
        int result = totalFeed;
        result = 31 * result + previousFeeds.hashCode();
        result = 31 * result + nextFeeds.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "totalFeed=" + totalFeed +
                ", previousFeeds='" + previousFeeds + '\'' +
                ", nextFeeds='" + nextFeeds + '\'' +
                '}';
    }
}