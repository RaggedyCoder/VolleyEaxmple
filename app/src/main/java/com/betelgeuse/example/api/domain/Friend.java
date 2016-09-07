package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

public class Friend {

    private User user;
    @SerializedName("m_friends")
    private int mutualFriends;

    public Friend() {
    }

    public Friend(User user, int mutualFriends) {

        this.user = user;
        this.mutualFriends = mutualFriends;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMutualFriends() {
        return mutualFriends;
    }

    public void setMutualFriends(int mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (mutualFriends != friend.mutualFriends) return false;
        if (!user.equals(friend.user)) return false;
        return this.mutualFriends == friend.getMutualFriends();
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + mutualFriends;
        return result;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "user=" + user +
                ", mutualFriends=" + mutualFriends +
                '}';
    }
}
