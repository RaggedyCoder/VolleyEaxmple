package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

public class NewsFeed {

    private User user;
    private long timestamp;
    private String status;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("type")
    private int newsType;

    public NewsFeed() {
    }

    public NewsFeed(User user, long timestamp, String status, String imageUrl, int newsType) {
        this.user = user;
        this.timestamp = timestamp;
        this.status = status;
        this.imageUrl = imageUrl;
        this.newsType = newsType;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsFeed newsFeed = (NewsFeed) o;

        if (timestamp != newsFeed.timestamp) return false;
        if (newsType != newsFeed.newsType) return false;
        if (!user.equals(newsFeed.user)) return false;
        if (!status.equals(newsFeed.status)) return false;
        return imageUrl.equals(newsFeed.imageUrl);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + status.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + newsType;
        return result;
    }

    @Override
    public String toString() {
        return "NewsFeed{" +
                "user=" + user +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", newsType=" + newsType +
                '}';
    }
}
