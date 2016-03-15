package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/15.
 * 听新闻properties
 */
public class DiscoveryAlbumProperties {
    long albumId;

    private String contentType;
    private String key;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
}
