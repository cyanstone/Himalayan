package com.my.cyanstone.himalayan.utils;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;
import com.my.cyanstone.himalayan.model.EditorRecommendAlbums;
import com.my.cyanstone.himalayan.model.HotRecommendsList;
import com.my.cyanstone.himalayan.model.SpecialColumn;
import com.my.cyanstone.himalayan.model.SpecialColumnList;
import com.my.cyanstone.himalayan.ui.activity.AlbumDetailPageActivity;

/**
 * Created by 95199 on 2016/3/17.
 */
public class ClickEvent {
    public static void DicoveryColumsClick(Context context,DiscoveryColumnsList item){
        Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
    }

    public static void DiscoveryHotRecommendsMoreClick(Context context,HotRecommendsList item) {
        Toast.makeText(context, item.isHasMore() + "",Toast.LENGTH_SHORT).show();
    }

    public static void DiscoveryEditorRecommendMoreClick(Context context,EditorRecommendAlbums item) {
        Toast.makeText(context, item.isHasMore() + "", Toast.LENGTH_SHORT).show();
    }

    public static void DiscoverySpecialColumsItemClick(Context context,SpecialColumnList data) {
        Toast.makeText(context,data.getTitle(),Toast.LENGTH_SHORT).show();
    }

    public static void DiscoverySpecialColumsMoreClick(Context context,SpecialColumn data) {
        Toast.makeText(context,data.isHasMore() + "",Toast.LENGTH_SHORT).show();
    }
}
