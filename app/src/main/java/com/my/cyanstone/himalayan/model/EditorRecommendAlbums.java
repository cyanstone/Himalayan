package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class EditorRecommendAlbums {
    private int ret;
    private String title;
    private boolean hasMore;
    private List<EditorHotRecommendAlbumsList> list = new ArrayList<EditorHotRecommendAlbumsList>();

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<EditorHotRecommendAlbumsList> getList() {
        return list;
    }

    public void setList(List<EditorHotRecommendAlbumsList> list) {
        this.list = list;
    }
}
