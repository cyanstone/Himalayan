package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/11.
 */
public class FocusImagesList {
    private int id;
    private String shortTitle;
    private String longTitle;
    private String pic;
    private int type;
    private long uid;
    private long trackId;
    private boolean isShare;
    private boolean is_External_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public boolean isShare() {
        return isShare;
    }

    public void setIsShare(boolean isShare) {
        this.isShare = isShare;
    }

    public boolean is_External_url() {
        return is_External_url;
    }

    public void setIs_External_url(boolean is_External_url) {
        this.is_External_url = is_External_url;
    }
}
