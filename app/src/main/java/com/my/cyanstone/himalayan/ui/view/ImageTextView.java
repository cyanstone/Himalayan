package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;
import com.my.cyanstone.himalayan.utils.LoadImageUtil;

import static com.my.cyanstone.himalayan.R.drawable.bg_zone_img_big;

/**
 * Created by 95199 on 2016/3/15.
 */
public class ImageTextView extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;

    private int mTextColor;
    private float mTextSize;
    private String mText;
    private int mImageRecourceId;

    private ImageTextClickListener mClickListener;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_text_image, this);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.ImageTextView);
        mTextSize = ta.getDimension(R.styleable.ImageTextView_textSize, 12);
        mTextColor = ta.getColor(R.styleable.ImageTextView_textColor, Color.BLACK);
        mText = ta.getString(R.styleable.ImageTextView_text);
        mImageRecourceId = ta.getResourceId(R.styleable.ImageTextView_imageSrc, bg_zone_img_big);
        ta.recycle();
        mImageView = (ImageView) findViewById(R.id.view_image);
        mTextView = (TextView) findViewById(R.id.view_text);
        mTextView.setTextColor(mTextColor);
        mTextView.setTextSize(mTextSize);
        mTextView.setText(mText);
        mImageView.setImageResource(mImageRecourceId);

        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.myOnClick();
            }
        });
    }

    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
    }

    public void  setOnImageTextClickListener(ImageTextClickListener listener) {
        mClickListener = listener;
    }


    public void setImageView(Context context,String url){
        LoadImageUtil.load(context, url, mImageView);
    }

    public void setText(String text){
        mTextView.setText(text);
    }

    public void setTextSize(float textSize) {
        mTextView.setTextSize(textSize);
    }

    public void setTextColor(int color){
        setTextColor(color);
    }

}

