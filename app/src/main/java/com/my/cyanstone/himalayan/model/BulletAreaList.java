package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/11.
 */
public class BulletAreaList {
    private long trackId;
    private String title;
    private String coverMiddle;
    private String tags;
    private String playPath32;
    private String playPath64;
    private long albumId;
    private String albumTitle;
    private int favoritesCounts;
    private long playsCounts;
    private int commentsCounts;
    private int sharesCounts;

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverMiddle() {
        return coverMiddle;
    }

    public void setCoverMiddle(String coverMiddle) {
        this.coverMiddle = coverMiddle;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPlayPath32() {
        return playPath32;
    }

    public void setPlayPath32(String playPath32) {
        this.playPath32 = playPath32;
    }

    public String getPlayPath64() {
        return playPath64;
    }

    public void setPlayPath64(String playPath64) {
        this.playPath64 = playPath64;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getFavoritesCounts() {
        return favoritesCounts;
    }

    public void setFavoritesCounts(int favoritesCounts) {
        this.favoritesCounts = favoritesCounts;
    }

    public long getPlaysCounts() {
        return playsCounts;
    }

    public void setPlaysCounts(long playsCounts) {
        this.playsCounts = playsCounts;
    }

    public int getCommentsCounts() {
        return commentsCounts;
    }

    public void setCommentsCounts(int commentsCounts) {
        this.commentsCounts = commentsCounts;
    }

    public int getSharesCounts() {
        return sharesCounts;
    }

    public void setSharesCounts(int sharesCounts) {
        this.sharesCounts = sharesCounts;
    }
}
