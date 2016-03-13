package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class DicoveryColumns {
    private int ret;
    private String title;
    private List<DicoveryColumnsList> list = new ArrayList<DicoveryColumnsList>();
    private int locationInHotRecommend;

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

    public List<DicoveryColumnsList> getList() {
        return list;
    }

    public void setList(List<DicoveryColumnsList> list) {
        this.list = list;
    }

    public int getLocationInHotRecommend() {
        return locationInHotRecommend;
    }

    public void setLocationInHotRecommend(int locationInHotRecommend) {
        this.locationInHotRecommend = locationInHotRecommend;
    }
}
