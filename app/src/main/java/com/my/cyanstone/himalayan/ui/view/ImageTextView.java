package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my.cyanstone.himalayan.R;

/**
 * Created by 95199 on 2016/3/15.
 */
public class ImageTextView extends LinearLayout {

    private ImageView mImageVIew;
    private TextView mTextView;

    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_text_image,this);
        init();
    }

    private void init() {
        mImageVIew = (ImageView) findViewById(R.id.view_image);
        mTextView = (TextView) findViewById(R.id.view_text);
    }

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
}
