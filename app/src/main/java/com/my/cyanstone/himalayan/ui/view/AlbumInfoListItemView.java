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
import com.my.cyanstone.himalayan.utils.LoadImageUtil;

/**
 * Created by 95199 on 2016/3/18.
 */

public class AlbumInfoListItemView extends LinearLayout {

    private String mTitleText,mSubtitleText,mFootnoteText;
    private int mImageSrcId,mTitleTextColorId,mSubtitleTextColorId,mFootnoteTextColorId;
    private float mTitleTextSize,mSubtitleTextSize,mFootnoteTextSize;
    private boolean mLineGone;

    private ImageView mImageView;
    private TextView mTitleView,mSubtitleView,mFootnoteView;
    private View mLine;

    private LinearLayout mLayout;

    private AlbumInfoListItemClickListener mListener;

    public AlbumInfoListItemView(Context context) {
        super(context);
    }

    public AlbumInfoListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AlbumInfoListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray da = context.obtainStyledAttributes(attrs, R.styleable.AlbumInfoListItemView);
        mTitleText = da.getString(R.styleable.AlbumInfoListItemView_albumTitleText);
        mSubtitleText = da.getString(R.styleable.AlbumInfoListItemView_subtitleText);
        mFootnoteText = da.getString(R.styleable.AlbumInfoListItemView_footnoteText);
        mImageSrcId = da.getResourceId(R.styleable.AlbumInfoListItemView_albumImageSrc, R.drawable.bg_zone_img_big);
        mTitleTextColorId = da.getResourceId(R.styleable.AlbumInfoListItemView_albumTitleTextColor,R.color.black_text);
        mSubtitleTextColorId = da.getResourceId(R.styleable.AlbumInfoListItemView_albumSubtitleTextColor,R.color.subtitle_text);
        mFootnoteTextColorId = da.getResourceId(R.styleable.AlbumInfoListItemView_footnoteTextColor,R.color.subtitle_text);
        mTitleTextSize = da.getDimension(R.styleable.AlbumInfoListItemView_albumTitleTextSize, 16);
        mSubtitleTextSize = da.getDimension(R.styleable.AlbumInfoListItemView_albumSubtileTextSize,12);
        mFootnoteTextSize = da.getDimension(R.styleable.AlbumInfoListItemView_footnoteTextSize,10);
        mLineGone = da.getBoolean(R.styleable.AlbumInfoListItemView_divideLineGone, false);
        da.recycle();

        LayoutInflater.from(context).inflate(R.layout.view_album_info_list_item, this);
        init();
    }

    private void init(){
        mImageView = (ImageView) findViewById(R.id.view_album_info_item_image);
        mTitleView = (TextView) findViewById(R.id.view_album_info_item_title);
        mSubtitleView = (TextView) findViewById(R.id.view_album_info_item_subtitle);
        mFootnoteView = (TextView) findViewById(R.id.view_album_info_item_footnote);
        mLine = findViewById(R.id.view_album_info_item_line);

        mLayout = (LinearLayout) findViewById(R.id.view_album_info_item_layout);

        mImageView.setImageResource(mImageSrcId);

        mTitleView.setText(mTitleText);
        mTitleView.setTextColor(Color.BLACK);
        mTitleView.setTextSize(mTitleTextSize);

        mSubtitleView.setText(mSubtitleText);
        mSubtitleView.setTextColor(mSubtitleTextColorId);
        mSubtitleView.setTextSize(mSubtitleTextSize);

        mFootnoteView.setText(mFootnoteText);
        mFootnoteView.setTextColor(mFootnoteTextColorId);
        mFootnoteView.setTextSize(mFootnoteTextSize);

        mLine.setVisibility(mLineGone ? View.GONE : View.VISIBLE);

        mLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick();
            }
        });
    }

    /**
     * 设置一系列Set方法
     */

    public void setLineGone(boolean lineGone) {
        mLine.setVisibility(lineGone ? View.GONE : View.VISIBLE);
    }

    public void setTitleText(String titleText) {
        mTitleView.setText(titleText);
    }

    public void setSubtitleText(String subtitleText) {
        mSubtitleView.setText(subtitleText);
    }

    public void setFootnoteText(String footnoteText) {
        mFootnoteView.setText(footnoteText);
    }

    public void setImageSrcId(int imageSrcId) {
        mImageView.setImageResource(imageSrcId);
    }

    public void setTitleTextColorId(int titleTextColorId) {
        mTitleView.setTextColor(titleTextColorId);
    }

    public void setSubtitleTextColorId(int subtitleTextColorId) {
        mSubtitleView.setTextColor(subtitleTextColorId);
    }

    public void setFootnoteTextColorId(int footnoteTextColorId) {
        mFootnoteView.setTextColor(footnoteTextColorId);
    }

    public void setTitleTextSize(float titleTextSize) {
        mTitleView.setTextSize(titleTextSize);
    }

    public void setSubtitleTextSize(float subtitleTextSize) {
        mSubtitleView.setTextSize(subtitleTextSize);
    }

    public void setFootnoteTextSize(float footnoteTextSize) {
        mFootnoteView.setTextSize(footnoteTextSize);
    }

    public void setLoadImage(Context context,String url) {
        LoadImageUtil.load(context,url,mImageView);
    }
    public void setOnItemClick(AlbumInfoListItemClickListener l) {
        mListener = l;
    }

    /**
     * 接口
     */
    public interface AlbumInfoListItemClickListener{
        public void onItemClick();
    }

}
