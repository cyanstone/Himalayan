package com.my.cyanstone.himalayan.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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

    public SpecialColumsView(Context context) {
        super(context);
    }

    public SpecialColumsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SpecialColumsView);
        mTitleSize = ta.getDimension(R.styleable.SpecialColumsView_specialColumsTitleSize,16);
        mTitleColor = ta.getResourceId(R.styleable.SpecialColumsView_specialColumsTitleColor, R.color.nav_text_Checked);
        mTitleText = ta.getString(R.styleable.SpecialColumsView_specialColumsTitleText);

        LayoutInflater.from(context).inflate(R.layout.view_special_column,this);
        mTitleView = (TextView) findViewById(R.id.view_special_column_title);
        mMoreView = (TextView) findViewById(R.id.view_special_column_more);
        mItemView1 = (AlbumInfoListItemView) findViewById(R.id.view_special_column_item1);
        mItemView2 = (AlbumInfoListItemView) findViewById(R.id.view_special_column_item2);

        mTitleView.setTextSize(mTitleSize);
        mMoreView.setTextSize(mTitleSize);

        mTitleView.setTextColor(mTitleColor);
        mTitleView.setText(mTitleText);
    }

    public void setTitleText(String title) {
        mTitleView.setText(title);
    }

    public void setTitleColor(int colorId) {
        mTitleView.setTextColor(colorId);
    }

    public void setTitleSize(float size) {
        mTitleView.setTextSize(size);
    }

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

    /**
     *  public void setLineGone(boolean lineGone) {
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

     public void setOnClickItemClick(AlbumInfoListItemClickListener l) {
     mListener = l;
     }
     * @param context
     * @param attrs
     * @param defStyleAttr
     */

    public SpecialColumsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
