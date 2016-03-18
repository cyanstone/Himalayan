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

    public SpecialColumsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
