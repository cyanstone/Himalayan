package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class HotRecommendsList {
    private String title;
    private String contentType;
    private boolean isFinished;
    private int categoryId;
    private int count;
    private boolean hasMore;
    private List<HotRecommendsListList> list = new ArrayList<HotRecommendsListList>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<HotRecommendsListList> getList() {
        return list;
    }

    public void setList(List<HotRecommendsListList> list) {
        this.list = list;
    }
}
