package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;
import com.my.cyanstone.himalayan.model.DiscoveryRecommend;
import com.my.cyanstone.himalayan.model.FocusImages;
import com.my.cyanstone.himalayan.model.FocusImagesList;
import com.my.cyanstone.himalayan.net.API;
import com.my.cyanstone.himalayan.net.MyHttpClient;
import com.my.cyanstone.himalayan.ui.view.FocusBannerHolderView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 95199 on 2016/1/17.
 */
public class DiscoveryRecommendFragment extends Fragment {
    private final static String TAG = "DiscoveryRecommendFragment";
    private final static String  recommendUrl =
            API.DISCOVERY_RECOMMEND;

    private DiscoveryRecommend mDiscoveryRecommend;
    private ConvenientBanner mConvenientBanner;
    private List<FocusImagesList> mFocusImagesLists;

    private List<Fragment> mDiscoveryColumsFragments;
    private ViewPager mDisvoeryColumsPagers;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_discovery_recommend, container, false);
        mConvenientBanner = (ConvenientBanner) v.findViewById(R.id.convenientBanner);
        fetchGson(v);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        mConvenientBanner.stopTurning();
    }

    private void fetchGson(final View v){
        Request request = new Request.Builder()
                .url(recommendUrl)
                .build();
        MyHttpClient.getHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Gson mgson = new Gson();
                    mDiscoveryRecommend = mgson.fromJson(response.body().string(), DiscoveryRecommend.class);
                    Log.d(TAG, "Gson parse DiscoveryRecommend Successful!");
                    mFocusImagesLists = mDiscoveryRecommend.getFocusImages().getList();
                    Log.d(TAG, "get FocusImage Uri");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initBanner(v);
                            initColums(v);
                        }

                    });
                }
            }
        });
    }

    private void initBanner(View v) {
        mConvenientBanner.setPages(new CBViewHolderCreator<FocusBannerHolderView>() {
            @Override
            public FocusBannerHolderView createHolder() {
                return new FocusBannerHolderView();
            }
        }, mFocusImagesLists)
                .setPageIndicator(new int[]
                        {R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                .startTurning(5000);
    }

    private void initColums(View v){
        mDiscoveryColumsFragments = new ArrayList<Fragment>();
        mDiscoveryColumsFragments.add(DiscoveryDiscoveryColums1Fragment.newInstance(mDiscoveryRecommend.getDiscoveryColumns().getList()));
        mDiscoveryColumsFragments.add(DiscoveryDiscoveryColums2Fragment.newInstance(mDiscoveryRecommend.getDiscoveryColumns().getList()));
        mDiscoveryColumsFragments.add(DiscoveryDiscoveryColums3Fragment.newInstance(mDiscoveryRecommend.getDiscoveryColumns().getList()));

        mDisvoeryColumsPagers = (ViewPager) v.findViewById(R.id.dicovery_view_Pager);
        mDisvoeryColumsPagers.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager() ) {
            @Override
            public Fragment getItem(int position) {
                return mDiscoveryColumsFragments.get(position);
            }

            @Override
            public int getCount() {
                return mDiscoveryColumsFragments.size();
            }
        });
        mDisvoeryColumsPagers.setBackgroundResource(R.color.tab_background);
    }

}
