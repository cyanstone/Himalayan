package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.utils.LoadImageUtil;

/**
 * Created by 95199 on 2016/3/19.
 */
public class DiscoveryBottomButtonView extends LinearLayout {

    private String mText;
    private float mTextSize;
    private int mImageSrc;

    private ImageView mImageView;
    private TextView mTextView;
    private LinearLayout mLayout;

    private DiscoveryBottomButtonClickListener mListener;

    public DiscoveryBottomButtonView(Context context) {
        super(context);
    }

    public DiscoveryBottomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DiscoveryBottomButtonView);
        mText = ta.getString(R.styleable.DiscoveryBottomButtonView_discovery_bottom_button_text);
        mTextSize = ta.getDimension(R.styleable.DiscoveryBottomButtonView_discovery_bottom_button_textSize, 16);
        mImageSrc = ta.getResourceId(R.styleable.DiscoveryBottomButtonView_discovery_bottom_button_imageSrc, R.drawable.bg_zone_img_big);

        LayoutInflater.from(context).inflate(R.layout.view_discovery_bottom_index_button,this);
        mImageView = (ImageView) findViewById(R.id.view_discovery_bottom_button_image);
        mTextView = (TextView) findViewById(R.id.view_discovery_bottom_button_text);
        mLayout = (LinearLayout) findViewById(R.id.view_discovery_bottom_button_layout);

        mImageView.setImageResource(mImageSrc);
        mTextView.setText(mText);
        mTextView.setTextSize(mTextSize);

        mListener = new DiscoveryBottomButtonClickListener() {
            @Override
            public void onDiscoveryBottomButtonClick() {

            }
        };

        mLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDiscoveryBottomButtonClick();
            }
        });
    }

    public void setOnButtonClickListener(DiscoveryBottomButtonClickListener l) {
        mListener = l;
    }

    public void setText(String text) {
        mTextView.setText(text);
    }

    public void setTextSize(float size) {
        mTextView.setTextSize(size);
    }

    public void loadImage(Context context,String url) {
        LoadImageUtil.load(context,url,mImageView);
    }

    public DiscoveryBottomButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface DiscoveryBottomButtonClickListener {
         void onDiscoveryBottomButtonClick();
    }
}
