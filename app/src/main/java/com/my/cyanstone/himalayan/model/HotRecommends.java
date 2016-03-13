package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class HotRecommends {
    private int ret;
    private String title;
    private List<HotRecommendsList> list = new ArrayList<HotRecommendsList>();

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

    public List<HotRecommendsList> getList() {
        return list;
    }

    public void setList(List<HotRecommendsList> list) {
        this.list = list;
    }
}
