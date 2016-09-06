package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

public class NewsFeed {

    @SerializedName("user_name")
    private String username;
    @SerializedName("p_url")
    private String profileUrl;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("pp_url")
    private String profilePictureUrl;
    private long timestamp;
    private String status;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("type")
    private int newsType;

    public NewsFeed() {
    }

    public NewsFeed(String username, String profileUrl, String fullName, String profilePictureUrl, long timestamp, String status, String imageUrl, int newsType) {

        this.username = username;
        this.profileUrl = profileUrl;
        this.fullName = fullName;
        this.profilePictureUrl = profilePictureUrl;
        this.timestamp = timestamp;
        this.status = status;
        this.imageUrl = imageUrl;
        this.newsType = newsType;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
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
        if (!username.equals(newsFeed.username)) return false;
        if (!profileUrl.equals(newsFeed.profileUrl)) return false;
        if (!fullName.equals(newsFeed.fullName)) return false;
        if (!profilePictureUrl.equals(newsFeed.profilePictureUrl)) return false;
        if (!status.equals(newsFeed.status)) return false;
        return imageUrl.equals(newsFeed.imageUrl);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + profileUrl.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + profilePictureUrl.hashCode();
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + status.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + newsType;
        return result;
    }

    @Override
    public String toString() {
        return "NewsFeed{" +
                "username='" + username + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", fullName='" + fullName + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", newsType=" + newsType +
                '}';
    }
}
