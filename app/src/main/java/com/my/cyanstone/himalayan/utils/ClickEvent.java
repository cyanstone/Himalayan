package com.my.cyanstone.himalayan.utils;

import android.content.Context;
import android.widget.Toast;

import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;

/**
 * Created by 95199 on 2016/3/17.
 */
public class ClickEvent {
    public static void DicoveryColumsClick(Context context,DiscoveryColumnsList item){
        Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
    }
}
