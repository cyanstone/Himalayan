package com.my.cyanstone.himalayan.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.my.cyanstone.himalayan.HimalayanApplication;
import com.my.cyanstone.himalayan.R;

/**
 * Created by 95199 on 2016/3/13.
 */
public class LoadImageUtil {
    public static void load(Context context,String url,ImageView imageView){
        Glide.with(context)
                .load(url)
                .error(R.drawable.bg_zone_img_big)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void load(Context context,String url,ImageView imageView,int errResourceId){
        Glide.with(context)
                .load(url)
                .error(errResourceId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


    public static void load(Context context,int resourceId,ImageView imageView) {
        Glide.with(context)
                .load(resourceId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg_zone_img_big)
                .into(imageView);
    }

    public static void load(Context context,int resourceId,ImageView imageView,int errResourceId) {
        Glide.with(context)
                .load(resourceId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.subject_default)
                .into(imageView);
    }

    public static void load(String url,int animationId,ImageView imageView){
        Glide.with(HimalayanApplication.sContext)
                .load(url)
                .animate(animationId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void loadWithHighPriority(String url,ImageView imageView) {
        Glide.with(HimalayanApplication.sContext)
                .load(url)
                .crossFade()
                .error(R.mipmap.subject_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imageView);
    }
}
