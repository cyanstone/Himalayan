package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
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
public class DownloadFragment extends Fragment {
    private static final String TAG = "DownloadFragment";
    private TextView mAlbumText,mVoiceText,mDownloadingText;
    private ViewPager mViewPager;
    private ImageView mCuorsor;
    private int mCurrentPageIndex = 0;
    private int mScreenWidth,mScreenHeitht,mCursorWidth;
    private List<Fragment> mFragments;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentsList();
    }

    private void initFragmentsList() {
        Fragment mAlbumFragment = new DownloadAlbumFragment();
        Fragment mVoiceFragment = new DownloadVoiceFragment();
        Fragment mDownloadingFragment = new DownloadDownloadingFragment();

        mFragments = new ArrayList<Fragment>();
        mFragments.add(mAlbumFragment);
        mFragments.add(mVoiceFragment);
        mFragments.add(mDownloadingFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_download,container,false);
        initTextView(v);
        initCurcor(v);
        initViewPager(v);
        return v;
    }

    private void initTextView(View v) {
        mAlbumText = (TextView) v.findViewById(R.id.download_nav_album_text);
        mVoiceText = (TextView) v.findViewById(R.id.download_nav_voice_text);
        mDownloadingText = (TextView) v.findViewById(R.id.download_nav_downloading_text);

        mAlbumText.setOnClickListener(new TextViewClickListener(0));
        mVoiceText.setOnClickListener(new TextViewClickListener(1));
        mDownloadingText.setOnClickListener(new TextViewClickListener(2));

        mAlbumText.setSelected(true);
    }

    private class TextViewClickListener implements View.OnClickListener {
        int  index;
        public TextViewClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(index);
        }
    }
    private void initCurcor(View v) {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        mScreenHeitht = dm.heightPixels;
        mScreenWidth = dm.widthPixels;
        mCursorWidth = mScreenWidth / 3;

        mCuorsor = (ImageView) v.findViewById(R.id.download_nav_cursor);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mCuorsor.getLayoutParams();
        layoutParams.width = mCursorWidth;
        layoutParams.height = mScreenHeitht / 160;
        mCuorsor.setLayoutParams(layoutParams);
    }

    private void initViewPager(View v) {
        mViewPager = (ViewPager) v.findViewById(R.id.download_view_pager);
        mViewPager.setAdapter(new MyViewPagerAdapter(getActivity().getSupportFragmentManager()));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mCuorsor.getLayoutParams();
                layoutParams.leftMargin = (int) (position * mCursorWidth + positionOffset * mCursorWidth);
                mCuorsor.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPageIndex = position;
                NavTextState();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            private void NavTextState() {
                mAlbumText.setSelected(false);
                mVoiceText.setSelected(false);
                mDownloadingText.setSelected(false);

                switch(mCurrentPageIndex) {
                    case 0:
                        mAlbumText.setSelected(true);
                        break;
                    case 1:
                        mVoiceText.setSelected(true);
                        break;
                    case 2:
                        mDownloadingText.setSelected(true);
                        break;
                    default:
                        Log.d(TAG,"NavTextState() has exception!");
                }
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
