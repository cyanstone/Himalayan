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
 * Created by 95199 on 2016/3/18.
 */
public class SpecialColumsView extends LinearLayout {

    private String mTitleText;
    private int mTitleColor;
    private float mTitleSize;

    private TextView mTitleView,mMoreView;
    private AlbumInfoListItemView mItemView1,mItemView2;

    private SpecialColumsMoreClickListener moreClickListener;

    public SpecialColumsView(Context context) {
        super(context);
    }

    public SpecialColumsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SpecialColumsView);
        mTitleSize = ta.getDimension(R.styleable.SpecialColumsView_specialColumsTitleSize,12);
        mTitleText = ta.getString(R.styleable.SpecialColumsView_specialColumsTitleText);
        ta.recycle();
        LayoutInflater.from(context).inflate(R.layout.view_special_column, this);
        mTitleView = (TextView) findViewById(R.id.view_special_column_title);
        mMoreView = (TextView) findViewById(R.id.view_special_column_more);
        mItemView1 = (AlbumInfoListItemView) findViewById(R.id.view_special_column_item1);
        mItemView2 = (AlbumInfoListItemView) findViewById(R.id.view_special_column_item2);

        mTitleView.setTextSize(mTitleSize);
        mMoreView.setTextSize(mTitleSize);

        mTitleView.setText(mTitleText);

        mMoreView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                moreClickListener.onMoreClick();
            }
        });
    }

    public void setTitleText(String title) {
        mTitleView.setText(title);
    }

    public void setTitleColor(int colorId) {
        mTitleView.setTextColor(colorId);
    }

    public void setTitleSize(float size) {
        mTitleView.setTextSize(size);
        mMoreView.setTextSize(size);
    }

    public void setOnMoreClickListener(SpecialColumsMoreClickListener l) {
        moreClickListener = l;
    }

    /**
     *Item1
     */
    public void setLineGone1(boolean lineGone) {
        mItemView1.setLineGone(lineGone);
    }

    public void setItemTitleText1(String title) {
        mItemView1.setTitleText(title);
    }

    public void setmItemTitleColor1(int colorId) {
        mItemView1.setTitleTextColorId(colorId);
    }

    public void setItemTitleSize1(float size) {
        mItemView1.setTitleTextSize(size);
    }

    public void setItemSubtitleText1(String subtitle) {
        mItemView1.setSubtitleText(subtitle);
    }

    public void setItemSubtitleTextSize1(float size) {
        mItemView1.setSubtitleTextSize(size);
    }

    public void setItemSubtitleTextColor1(int color) {
        mItemView1.setSubtitleTextColorId(color);
    }

    public void setItemFootnoteText1(String text) {
        mItemView1.setFootnoteText(text);
    }

    public void setItemFootnoteTextColor1(int color) {
        mItemView1.setSubtitleTextColorId(color);
    }

    public void setItemFootnoteTextSize1(float note) {
        mItemView1.setFootnoteTextSize(note);
    }
    public void setItemImage1(Context context,String url) {
        mItemView1.setLoadImage(context, url);
    }

    public void setOnItemViewClickListener1(AlbumInfoListItemView.AlbumInfoListItemClickListener l) {
        mItemView1.setOnItemClick(l);
    }

    /**
     * Item2
     */
    public void setLineGone2(boolean lineGone) {
        mItemView2.setLineGone(lineGone);
    }

    public void setItemTitleText2(String title) {
        mItemView2.setTitleText(title);
    }

    public void setmItemTitleColor2(int colorId) {
        mItemView2.setTitleTextColorId(colorId);
    }

    public void setItemTitleSize2(float size) {
        mItemView2.setTitleTextSize(size);
    }

    public void setItemSubtitleText2(String subtitle) {
        mItemView2.setSubtitleText(subtitle);
    }

    public void setItemSubtitleTextSize2(float size) {
        mItemView2.setSubtitleTextSize(size);
    }

    public void setItemSubtitleTextColor2(int color) {
        mItemView2.setSubtitleTextColorId(color);
    }

    public void setItemFootnoteText2(String text) {
        mItemView2.setFootnoteText(text);
    }

    public void setItemFootnoteTextColor2(int color) {
        mItemView2.setSubtitleTextColorId(color);
    }

    public void setItemFootnoteTextSize2(float note) {
        mItemView2.setFootnoteTextSize(note);
    }
    public void setItemImage2(Context context,String url) {
        mItemView2.setLoadImage(context, url);
    }

    public void setOnItemViewClickListener2(AlbumInfoListItemView.AlbumInfoListItemClickListener l) {
        mItemView2.setOnItemClick(l);
    }

    public SpecialColumsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface SpecialColumsMoreClickListener{
        public void onMoreClick();
    }
}
