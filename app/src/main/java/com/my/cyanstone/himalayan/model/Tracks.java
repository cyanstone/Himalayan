package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;

/**
 * Created by CyanStone on 2016/3/19.
 */
public class Tracks {
    private ArrayList<TracksList> list;
    private int pageId;
    private int pageSize;
    private int maxPageId;
    private int totalCount;

    public ArrayList<TracksList> getList() {
        return list;
    }

    public void setList(ArrayList<TracksList> list) {
        this.list = list;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPageId() {
        return maxPageId;
    }

    public void setMaxPageId(int maxPageId) {
        this.maxPageId = maxPageId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
