package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.Holder;
import com.my.cyanstone.himalayan.HimalayanApplication;
import com.my.cyanstone.himalayan.model.FocusImagesList;
import com.my.cyanstone.himalayan.utils.LoadImageUtil;

/**
 * Created by 95199 on 2016/3/13.
 */
public class FocusBannerHolderView implements Holder<FocusImagesList>{
    private ImageView mImageView;
    public View createView(Context context) {
        mImageView =  new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, final FocusImagesList data) {
        LoadImageUtil.loadWithHighPriority(data.getPic(),mImageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HimalayanApplication.sContext,data.getShortTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
