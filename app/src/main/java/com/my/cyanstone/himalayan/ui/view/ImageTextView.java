package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 95199 on 2016/3/15.
 */
public class ImageTextView extends LinearLayout {

    private ImageView mImageVIew;
    private TextView mTextView;
    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
}
