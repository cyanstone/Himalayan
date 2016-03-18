package com.my.cyanstone.himalayan.ui.fragment;

import android.content.Intent;
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
import com.my.cyanstone.himalayan.ui.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/8.
 */
public class DiscoveryFragment extends Fragment {
    private final static String TAG = "DiscoveryFragment";
    private ViewPager mViewPager;
    private TextView mTextViewRecommend, mTextViewClassify,
            mTextViewBroad,mTextViewRankList,mTextViewHost;
    private ImageView mCursorImageView,mSearchImageView;
    int mScreenWidth = 0, mScreenHeight = 0, mCurPageIndex = 0,mCurImageWidth = 0;
    private List<Fragment> mFragments;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discovery,container,false);
        initTextView(v);
        initImageView(v);
        initViewPager(v);
        return v;
    }

    private void initFragmentList() {
        Fragment  recommendFragment = new DiscoveryRecommendFragment();
        Fragment classifyFragment = new DiscoveryClassifyFragment();
        Fragment broadFragment = new DiscoveryBroadFragment();
        Fragment rankListFragment = new DiscoveryRankListFragment();
        Fragment hostFragment = new DiscoveryHostFragment();

        mFragments = new ArrayList<Fragment>();
        mFragments.add(recommendFragment);
        mFragments.add(classifyFragment);
        mFragments.add(broadFragment);
        mFragments.add(rankListFragment);
        mFragments.add(hostFragment);
    }

    private void initTextView(View v){
        mTextViewRecommend = (TextView) v.findViewById(R.id.text_nav1);
        mTextViewClassify = (TextView) v.findViewById(R.id.text_nav2);
        mTextViewBroad = (TextView) v.findViewById(R.id.text_nav3);
        mTextViewRankList = (TextView) v.findViewById(R.id.text_nav4);
        mTextViewHost = (TextView) v.findViewById(R.id.text_nav5);

        mTextViewRecommend.setOnClickListener(new TextClickListener(0));
        mTextViewClassify.setOnClickListener(new TextClickListener(1));
        mTextViewBroad.setOnClickListener(new TextClickListener(2));
        mTextViewRankList.setOnClickListener(new TextClickListener(3));
        mTextViewHost.setOnClickListener(new TextClickListener(4));

        mTextViewRecommend.setSelected(true);
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
    private void initImageView(View v){
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getActivity().getWindow().getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
        mScreenWidth = dpMetrics.widthPixels;
        mScreenHeight = dpMetrics.heightPixels;

        mCurImageWidth = mScreenWidth / 5;

        Log.d(TAG, "Screen:" + mScreenWidth + "*" + mScreenHeight);

        mCursorImageView = (ImageView) v.findViewById(R.id.cursor);
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams) mCursorImageView.getLayoutParams();
        layoutParams.width = mCurImageWidth;
        layoutParams.height = mScreenHeight / 150;
        mCursorImageView.setLayoutParams(layoutParams);

        mSearchImageView = (ImageView) v.findViewById(R.id.imgView_search);
        mSearchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以后实现
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_right);
            }
        });
    }
    private void  initViewPager(View v) {
        mViewPager = (ViewPager)v.findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyViewPagerAdapter(getActivity().getSupportFragmentManager()));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //  Log.d(TAG,"position = " + position + ",positionOffset = " + positionOffset + ",positionOffsetPixels =" + positionOffsetPixels);

                RelativeLayout.LayoutParams layoutParams =
                        (RelativeLayout.LayoutParams) mCursorImageView.getLayoutParams();
                layoutParams.leftMargin = (int) (mCurImageWidth * positionOffset + position * mCurImageWidth);
                //  Log.d(TAG,layoutParams.leftMargin+"");
                mCursorImageView.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                mCurPageIndex = position;
                navTextSelectState();
            }

            private void navTextSelectState() {
                mTextViewRecommend.setSelected(false);
                mTextViewClassify.setSelected(false);
                mTextViewBroad.setSelected(false);
                mTextViewRankList.setSelected(false);
                mTextViewHost.setSelected(false);
                switch (mCurPageIndex) {
                    case 0:
                        mTextViewRecommend.setSelected(true);
                        break;
                    case 1:
                        mTextViewClassify.setSelected(true);
                        break;
                    case 2:
                        mTextViewBroad.setSelected(true);
                        break;
                    case 3:
                        mTextViewRankList.setSelected(true);
                        break;
                    case 4:
                        mTextViewHost.setSelected(true);
                        break;
                    default:
                        Log.d(TAG,"NavTextSeclecteState() have excepiton");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
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
