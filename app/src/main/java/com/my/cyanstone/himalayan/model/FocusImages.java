package com.my.cyanstone.himalayan.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class FocusImages {
    private int ret;
    private List<FocusImagesList> list = new ArrayList<FocusImagesList>();
    private String title;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<FocusImagesList> getList() {
        return list;
    }

    public void setList(List<FocusImagesList> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
