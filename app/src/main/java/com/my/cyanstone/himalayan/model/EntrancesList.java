package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/11.
 */
public class EntrancesList {
    private int id;
    private String entranceType;
    private String coverPath;
    private String title;

    public EntrancesList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntranceType() {
        return entranceType;
    }

    public void setEntranceType(String entranceType) {
        this.entranceType = entranceType;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
