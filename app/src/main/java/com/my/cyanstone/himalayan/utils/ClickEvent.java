package com.my.cyanstone.himalayan.utils;

import android.content.Context;
import android.widget.Toast;

import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;
import com.my.cyanstone.himalayan.model.EditorRecommendAlbums;
import com.my.cyanstone.himalayan.model.HotRecommendsList;

/**
 * Created by 95199 on 2016/3/17.
 */
public class ClickEvent {
    public static void DicoveryColumsClick(Context context,DiscoveryColumnsList item){
        Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
    }
    public static void DiscoveryHotRecommendsClick(Context context,EditorHotRecommendAlbumsList item) {
        Toast.makeText(context, item.getTrackTitle(),Toast.LENGTH_SHORT).show();
    }

    public static void DiscoveryHotRecommendsMoreClick(Context context,HotRecommendsList item) {
        Toast.makeText(context, item.isHasMore() + "",Toast.LENGTH_SHORT).show();
    }

    public static void DiscoveryEditorRecommendMoreClick(Context context,EditorRecommendAlbums item) {
        Toast.makeText(context, item.isHasMore() + "", Toast.LENGTH_SHORT).show();
    }
}
