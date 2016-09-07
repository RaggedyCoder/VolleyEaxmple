package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/7/2016.
 */

public class User {

    @SerializedName("user_name")
    private String username;
    @SerializedName("p_url")
    private String profileUrl;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("pp_url")
    private String profilePictureUrl;

    public User() {
    }

    public User(String username, String profileUrl, String fullName, String profilePictureUrl) {

        this.username = username;
        this.profileUrl = profileUrl;
        this.fullName = fullName;
        this.profilePictureUrl = profilePictureUrl;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!profileUrl.equals(user.profileUrl)) return false;
        if (!fullName.equals(user.fullName)) return false;
        return profilePictureUrl.equals(user.profilePictureUrl);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + profileUrl.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + profilePictureUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", fullName='" + fullName + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                '}';
    }
}
