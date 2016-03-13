package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.my.cyanstone.himalayan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/8.
 */
public class CustomizationFragment extends Fragment{
    private static final String TAG = "CustomizationFragment";
    private ViewPager mViewPager;
    private TextView mRecommendTextView,mSubscribeTextView,mHistoryTextView;
    private ImageView mCursorImage;
    private List<Fragment> mFragments;
    private int mCurrentPageIndex = 1;
    private int mSreenWidth = 0, mScreenHeight = 0, mCurImageWidth = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    private void initFragmentList() {
        Fragment recommendFragment = new CustomizationRecommendFragment();
        Fragment subscribeFragment = new CustomizationSubscribeFragment();
        Fragment historyFragment = new CustomizationHistoryFragment();

        mFragments = new ArrayList<Fragment>();
        mFragments.add(recommendFragment);
        mFragments.add(subscribeFragment);
        mFragments.add(historyFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customization,container,false);
        initTextView(v);
        initCursorImageView(v);
        initViewPager(v);
        return v;
    }

    private void initTextView(View v) {
        mRecommendTextView = (TextView) v.findViewById(R.id.cus_nav_recommend);
        mSubscribeTextView = (TextView) v.findViewById(R.id.cus_nav_subscribe);
        mHistoryTextView = (TextView) v.findViewById(R.id.cus_nav_history);

        mRecommendTextView.setOnClickListener(new TextClickListener(0));
        mSubscribeTextView.setOnClickListener(new TextClickListener(1));
        mHistoryTextView.setOnClickListener(new TextClickListener(2));

        mSubscribeTextView.setSelected(true);
    }

    private class  TextClickListener implements View.OnClickListener {
        int index = 0;
        public TextClickListener(int index){
            this.index = index;
        }
        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(index);
        }
    }

    private void initCursorImageView(View v) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mSreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        mCurImageWidth = mSreenWidth / 3;

        mCursorImage = (ImageView) v.findViewById(R.id.custom_cursor);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mCursorImage.getLayoutParams();
        layoutParams.width = mCurImageWidth;
        layoutParams.height = mScreenHeight / 160;
        layoutParams.leftMargin = mCurImageWidth;
        mCursorImage.setLayoutParams(layoutParams);

    }

    private void initViewPager(View v) {
        mViewPager = (ViewPager) v.findViewById(R.id.cus_view_pager);
        mViewPager.setAdapter(new MyViewPagerAdapter(getActivity().getSupportFragmentManager()));
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mCursorImage.getLayoutParams();
                layoutParams.leftMargin = (int) (mCurImageWidth * position + mCurImageWidth * positionOffset);
                mCursorImage.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPageIndex = position;
                navTextState();
            }

            private void navTextState() {
                mRecommendTextView.setSelected(false);
                mSubscribeTextView.setSelected(false);
                mHistoryTextView.setSelected(false);

                switch (mCurrentPageIndex){
                    case 0:
                        mRecommendTextView.setSelected(true);
                        break;
                    case 1:
                        mSubscribeTextView.setSelected(true);
                        break;
                    case 2:
                        mHistoryTextView.setSelected(true);
                        break;
                    default:
                        Log.d(TAG, "NavTextView has exception!");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        public MyViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
