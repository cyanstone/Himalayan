package com.my.cyanstone.himalayan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/11.
 */
public class Entrances {
    private int ret;
    private List<EntrancesList> list = new ArrayList<EntrancesList>();

    public Entrances(){
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<EntrancesList> getList() {
        return list;
    }

    public void setList(List<EntrancesList> list) {
        this.list = list;
    }
}
