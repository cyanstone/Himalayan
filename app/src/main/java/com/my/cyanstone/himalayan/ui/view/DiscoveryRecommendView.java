package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my.cyanstone.himalayan.R;


/**
 * Created by 95199 on 2016/3/17.
 */
public class DiscoveryRecommendView extends LinearLayout {

    private String mTitleText,mTagText1,mTagText2,mTagText3;
    private int mBackgroudId,mImageSrcId1,mImageSrcId2,mImageSrcId3;
    private float mTitleSize,mTagTextSize;

    private TextView mTitleView,mMoreView;
    private ImageTextView mImageTextView1,mImageTextView2,mImageTextView3;

    private MoreClickListener mMoreClickListener;


    public DiscoveryRecommendView(Context context) {
        super(context);
    }

    public DiscoveryRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DiscoveryRecommendView);
        mTitleText = ta.getString(R.styleable.DiscoveryRecommendView_titleText);
        mTagText1 = ta.getString(R.styleable.DiscoveryRecommendView_tagText1);
        mTagText2 = ta.getString(R.styleable.DiscoveryRecommendView_tagText2);
        mTagText3 = ta.getString(R.styleable.DiscoveryRecommendView_tagText3);
        mBackgroudId = ta.getResourceId(R.styleable.DiscoveryRecommendView_view_background, R.color.tab_background);
        mImageSrcId1 = ta.getResourceId(R.styleable.DiscoveryRecommendView_imageSrc1, R.drawable.bg_zone_img_big);
        mImageSrcId2 = ta.getResourceId(R.styleable.DiscoveryRecommendView_imageSrc2, R.drawable.bg_zone_img_big);
        mImageSrcId3 = ta.getResourceId(R.styleable.DiscoveryRecommendView_imageSrc3, R.drawable.bg_zone_img_big);
        mTitleSize = ta.getDimension(R.styleable.DiscoveryRecommendView_titleTextSize, 12);
        mTagTextSize = ta.getDimension(R.styleable.DiscoveryRecommendView_tagTextSize, 12);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.view_discovery_hot_recommends, this);
        init();
    }

    public DiscoveryRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mTitleView = (TextView) findViewById(R.id.view_discovery_hot_recommend_title);
        mMoreView = (TextView) findViewById(R.id.view_discovery_hot_recommend_more);
        mImageTextView1 = (ImageTextView) findViewById(R.id.view_discovery_hot_recommend_it1);
        mImageTextView2 = (ImageTextView) findViewById(R.id.view_discovery_hot_recommend_it2);
        mImageTextView3 = (ImageTextView) findViewById(R.id.view_discovery_hot_recommend_it3);

        mTitleView.setText(mTitleText);
        mTitleView.setTextSize(mTitleSize);
        mMoreView.setTextSize(mTitleSize);
        mMoreView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoreClickListener.moreClick();
            }
        });

        mImageTextView1.setText(mTagText1);
        mImageTextView1.setImageView(mImageSrcId1);
        mImageTextView1.setTextSize(mTagTextSize);

        mImageTextView2.setText(mTagText2);
        mImageTextView2.setImageView(mImageSrcId2);
        mImageTextView2.setTextSize(mTagTextSize);

        mImageTextView3.setText(mTagText3);
        mImageTextView3.setImageView(mImageSrcId3);
        mImageTextView3.setTextSize(mTagTextSize);

        this.setBackgroundColor(mBackgroudId);
    }

    public void  setImageView1(Context context, String url) {
        mImageTextView1.setImageView(context,url);
    }

    public void setTagText1(String text) {
        mImageTextView1.setText(text);
    }

    public void  setImageView2(Context context, String url) {
        mImageTextView2.setImageView(context, url);
    }

    public void setTagText2(String text) {
        mImageTextView2.setText(text);
    }

    public void  setImageView3(Context context, String url) {
        mImageTextView3.setImageView(context, url);
    }

    public void setTagText3(String text) {
        mImageTextView3.setText(text);
    }

    public void setTitleText(String text) {
        mTitleView.setText(text);
    }

    public void setTitleSize(float size) {
        mTitleView.setTextSize(size);
    }

    public void setBackgroudId(int id) {
        this.setBackgroundColor(id);
    }

    public void setTagTextSize(float size) {
        mImageTextView1.setTextSize(size);
        mImageTextView2.setTextSize(size);
        mImageTextView3.setTextSize(size);
    }

    public void setOnListener1(ImageTextClickListener l) {
        mImageTextView1.setOnImageTextClickListener(l);
    }

    public void setOnListener2(ImageTextClickListener l) {
        mImageTextView2.setOnImageTextClickListener(l);
    }

    public void setOnListener3(ImageTextClickListener l) {
        mImageTextView3.setOnImageTextClickListener(l);
    }

    public void setOnMoreClickListener(MoreClickListener l) {
        mMoreClickListener = l;
    }

    public interface MoreClickListener{
        public void moreClick();
    }
}
