package com.betelgeuse.example.api.domain;

import com.google.gson.annotations.SerializedName;

public class MetaData {
    @SerializedName("t_data")
    private int totalData;
    @SerializedName("p_link")
    private String previousDataLink;
    @SerializedName("n_link")
    private String nextDataLink;

    public MetaData() {
    }

    public MetaData(int totalData, String previousDataLink, String nextDataLink) {

        this.totalData = totalData;
        this.previousDataLink = previousDataLink;
        this.nextDataLink = nextDataLink;
    }

    public int getTotalData() {

        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public String getPreviousDataLink() {
        return previousDataLink;
    }

    public void setPreviousDataLink(String previousDataLink) {
        this.previousDataLink = previousDataLink;
    }

    public String getNextDataLink() {
        return nextDataLink;
    }

    public void setNextDataLink(String nextDataLink) {
        this.nextDataLink = nextDataLink;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaData metaData = (MetaData) o;

        if (totalData != metaData.totalData) return false;
        if (!previousDataLink.equals(metaData.previousDataLink)) return false;
        return nextDataLink.equals(metaData.nextDataLink);

    }

    @Override
    public int hashCode() {
        int result = totalData;
        result = 31 * result + previousDataLink.hashCode();
        result = 31 * result + nextDataLink.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "totalData=" + totalData +
                ", previousDataLink='" + previousDataLink + '\'' +
                ", nextDataLink='" + nextDataLink + '\'' +
                '}';
    }
}