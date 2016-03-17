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
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;
import com.my.cyanstone.himalayan.model.FocusImages;
import com.my.cyanstone.himalayan.model.FocusImagesList;
import com.my.cyanstone.himalayan.model.HotRecommendsList;
import com.my.cyanstone.himalayan.net.API;
import com.my.cyanstone.himalayan.net.MyHttpClient;
import com.my.cyanstone.himalayan.ui.view.DiscoveryRecommendView;
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

    private DiscoveryRecommendView mDiscoeryRecommend1,mDiscoeryRecommend2,mDiscoeryRecommend3,mDiscoeryRecommend4,mDiscoeryRecommend5
    ,mDiscoeryRecommend6,mDiscoeryRecommend7,mDiscoeryRecommend8,mDiscoeryRecommend9,mDiscoeryRecommend10,mDiscoeryRecommend11,mDiscoeryRecommend12
    ,mDiscoeryRecommend13,mDiscoeryRecommend14;
    private List<HotRecommendsList> hotRecommendsLists;
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
                            initHotRecommends(v);
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

    private void initHotRecommends(View v) {
        mDiscoeryRecommend1 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view1);
        mDiscoeryRecommend2 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view2);
        mDiscoeryRecommend3 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view3);
        mDiscoeryRecommend4 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view4);
        mDiscoeryRecommend5 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view5);
        mDiscoeryRecommend6 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view6);
        mDiscoeryRecommend7 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view7);
        mDiscoeryRecommend8 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view8);
        mDiscoeryRecommend9 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view9);
        mDiscoeryRecommend10 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view10);
        mDiscoeryRecommend11 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view11);
        mDiscoeryRecommend12 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view12);
        mDiscoeryRecommend13 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view13);
        mDiscoeryRecommend14 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view14);

        hotRecommendsLists = mDiscoveryRecommend.getHotRecommends().getList();
        mDiscoeryRecommend1.setTitleText(hotRecommendsLists.get(0).getTitle());
        mDiscoeryRecommend1.setImageView1(getActivity(), hotRecommendsLists.get(0).getList().get(0).getCoverLarge());
        mDiscoeryRecommend1.setTagText1(hotRecommendsLists.get(0).getList().get(0).getTrackTitle());
        mDiscoeryRecommend1.setImageView2(getActivity(), hotRecommendsLists.get(0).getList().get(1).getCoverLarge());
        mDiscoeryRecommend1.setTagText2(hotRecommendsLists.get(0).getList().get(1).getTrackTitle());
        mDiscoeryRecommend1.setImageView3(getActivity(), hotRecommendsLists.get(0).getList().get(2).getCoverLarge());
        mDiscoeryRecommend1.setTagText3(hotRecommendsLists.get(0).getList().get(2).getTrackTitle());

        mDiscoeryRecommend2.setTitleText(hotRecommendsLists.get(1).getTitle());
        mDiscoeryRecommend2.setImageView1(getActivity(), hotRecommendsLists.get(1).getList().get(0).getCoverLarge());
        mDiscoeryRecommend2.setTagText1(hotRecommendsLists.get(1).getList().get(0).getTrackTitle());
        mDiscoeryRecommend2.setImageView2(getActivity(),hotRecommendsLists.get(1).getList().get(1).getCoverLarge());
        mDiscoeryRecommend2.setTagText2(hotRecommendsLists.get(1).getList().get(1).getTrackTitle());
        mDiscoeryRecommend2.setImageView3(getActivity(),hotRecommendsLists.get(1).getList().get(2).getCoverLarge());
        mDiscoeryRecommend2.setTagText3(hotRecommendsLists.get(1).getList().get(2).getTrackTitle());

        mDiscoeryRecommend3.setTitleText(hotRecommendsLists.get(2).getTitle());
        mDiscoeryRecommend3.setImageView1(getActivity(), hotRecommendsLists.get(2).getList().get(0).getCoverLarge());
        mDiscoeryRecommend3.setTagText1(hotRecommendsLists.get(2).getList().get(0).getTrackTitle());
        mDiscoeryRecommend3.setImageView2(getActivity(),hotRecommendsLists.get(2).getList().get(1).getCoverLarge());
        mDiscoeryRecommend3.setTagText2(hotRecommendsLists.get(2).getList().get(1).getTrackTitle());
        mDiscoeryRecommend3.setImageView3(getActivity(),hotRecommendsLists.get(2).getList().get(2).getCoverLarge());
        mDiscoeryRecommend3.setTagText3(hotRecommendsLists.get(2).getList().get(2).getTrackTitle());

        mDiscoeryRecommend4.setTitleText(hotRecommendsLists.get(3).getTitle());
        mDiscoeryRecommend4.setImageView1(getActivity(), hotRecommendsLists.get(3).getList().get(0).getCoverLarge());
        mDiscoeryRecommend4.setTagText1(hotRecommendsLists.get(3).getList().get(0).getTrackTitle());
        mDiscoeryRecommend4.setImageView2(getActivity(),hotRecommendsLists.get(3).getList().get(1).getCoverLarge());
        mDiscoeryRecommend4.setTagText2(hotRecommendsLists.get(3).getList().get(1).getTrackTitle());
        mDiscoeryRecommend4.setImageView3(getActivity(),hotRecommendsLists.get(3).getList().get(2).getCoverLarge());
        mDiscoeryRecommend4.setTagText3(hotRecommendsLists.get(3).getList().get(2).getTrackTitle());

        mDiscoeryRecommend5.setTitleText(hotRecommendsLists.get(4).getTitle());
        mDiscoeryRecommend5.setImageView1(getActivity(), hotRecommendsLists.get(4).getList().get(0).getCoverLarge());
        mDiscoeryRecommend5.setTagText1(hotRecommendsLists.get(4).getList().get(0).getTrackTitle());
        mDiscoeryRecommend5.setImageView2(getActivity(),hotRecommendsLists.get(4).getList().get(1).getCoverLarge());
        mDiscoeryRecommend5.setTagText2(hotRecommendsLists.get(4).getList().get(1).getTrackTitle());
        mDiscoeryRecommend5.setImageView3(getActivity(),hotRecommendsLists.get(4).getList().get(2).getCoverLarge());
        mDiscoeryRecommend5.setTagText3(hotRecommendsLists.get(4).getList().get(2).getTrackTitle());

        mDiscoeryRecommend6.setTitleText(hotRecommendsLists.get(5).getTitle());
        mDiscoeryRecommend6.setImageView1(getActivity(), hotRecommendsLists.get(5).getList().get(0).getCoverLarge());
        mDiscoeryRecommend6.setTagText1(hotRecommendsLists.get(5).getList().get(0).getTrackTitle());
        mDiscoeryRecommend6.setImageView2(getActivity(),hotRecommendsLists.get(5).getList().get(1).getCoverLarge());
        mDiscoeryRecommend6.setTagText2(hotRecommendsLists.get(5).getList().get(1).getTrackTitle());
        mDiscoeryRecommend6.setImageView3(getActivity(),hotRecommendsLists.get(5).getList().get(2).getCoverLarge());
        mDiscoeryRecommend6.setTagText3(hotRecommendsLists.get(5).getList().get(2).getTrackTitle());

        mDiscoeryRecommend7.setTitleText(hotRecommendsLists.get(6).getTitle());
        mDiscoeryRecommend7.setImageView1(getActivity(), hotRecommendsLists.get(6).getList().get(0).getCoverLarge());
        mDiscoeryRecommend7.setTagText1(hotRecommendsLists.get(6).getList().get(0).getTrackTitle());
        mDiscoeryRecommend7.setImageView2(getActivity(),hotRecommendsLists.get(6).getList().get(1).getCoverLarge());
        mDiscoeryRecommend7.setTagText2(hotRecommendsLists.get(6).getList().get(1).getTrackTitle());
        mDiscoeryRecommend7.setImageView3(getActivity(),hotRecommendsLists.get(6).getList().get(2).getCoverLarge());
        mDiscoeryRecommend7.setTagText3(hotRecommendsLists.get(6).getList().get(2).getTrackTitle());

        mDiscoeryRecommend8.setTitleText(hotRecommendsLists.get(7).getTitle());
        mDiscoeryRecommend8.setImageView1(getActivity(), hotRecommendsLists.get(7).getList().get(0).getCoverLarge());
        mDiscoeryRecommend8.setTagText1(hotRecommendsLists.get(7).getList().get(0).getTrackTitle());
        mDiscoeryRecommend8.setImageView2(getActivity(),hotRecommendsLists.get(7).getList().get(1).getCoverLarge());
        mDiscoeryRecommend8.setTagText2(hotRecommendsLists.get(7).getList().get(1).getTrackTitle());
        mDiscoeryRecommend8.setImageView3(getActivity(),hotRecommendsLists.get(7).getList().get(2).getCoverLarge());
        mDiscoeryRecommend8.setTagText3(hotRecommendsLists.get(7).getList().get(2).getTrackTitle());

        mDiscoeryRecommend9.setTitleText(hotRecommendsLists.get(8).getTitle());
        mDiscoeryRecommend9.setImageView1(getActivity(), hotRecommendsLists.get(8).getList().get(0).getCoverLarge());
        mDiscoeryRecommend9.setTagText1(hotRecommendsLists.get(8).getList().get(0).getTrackTitle());
        mDiscoeryRecommend9.setImageView2(getActivity(),hotRecommendsLists.get(8).getList().get(1).getCoverLarge());
        mDiscoeryRecommend9.setTagText2(hotRecommendsLists.get(8).getList().get(1).getTrackTitle());
        mDiscoeryRecommend9.setImageView3(getActivity(),hotRecommendsLists.get(8).getList().get(2).getCoverLarge());
        mDiscoeryRecommend9.setTagText3(hotRecommendsLists.get(8).getList().get(2).getTrackTitle());

        mDiscoeryRecommend10.setTitleText(hotRecommendsLists.get(9).getTitle());
        mDiscoeryRecommend10.setImageView1(getActivity(), hotRecommendsLists.get(9).getList().get(0).getCoverLarge());
        mDiscoeryRecommend10.setTagText1(hotRecommendsLists.get(9).getList().get(0).getTrackTitle());
        mDiscoeryRecommend10.setImageView2(getActivity(),hotRecommendsLists.get(9).getList().get(1).getCoverLarge());
        mDiscoeryRecommend10.setTagText2(hotRecommendsLists.get(9).getList().get(1).getTrackTitle());
        mDiscoeryRecommend10.setImageView3(getActivity(),hotRecommendsLists.get(9).getList().get(2).getCoverLarge());
        mDiscoeryRecommend10.setTagText3(hotRecommendsLists.get(9).getList().get(2).getTrackTitle());

        mDiscoeryRecommend11.setTitleText(hotRecommendsLists.get(10).getTitle());
        mDiscoeryRecommend11.setImageView1(getActivity(), hotRecommendsLists.get(10).getList().get(0).getCoverLarge());
        mDiscoeryRecommend11.setTagText1(hotRecommendsLists.get(10).getList().get(0).getTrackTitle());
        mDiscoeryRecommend11.setImageView2(getActivity(),hotRecommendsLists.get(10).getList().get(1).getCoverLarge());
        mDiscoeryRecommend11.setTagText2(hotRecommendsLists.get(10).getList().get(1).getTrackTitle());
        mDiscoeryRecommend11.setImageView3(getActivity(),hotRecommendsLists.get(10).getList().get(2).getCoverLarge());
        mDiscoeryRecommend11.setTagText3(hotRecommendsLists.get(10).getList().get(2).getTrackTitle());

        mDiscoeryRecommend12.setTitleText(hotRecommendsLists.get(11).getTitle());
        mDiscoeryRecommend12.setImageView1(getActivity(), hotRecommendsLists.get(11).getList().get(0).getCoverLarge());
        mDiscoeryRecommend12.setTagText1(hotRecommendsLists.get(11).getList().get(0).getTrackTitle());
        mDiscoeryRecommend12.setImageView2(getActivity(),hotRecommendsLists.get(11).getList().get(1).getCoverLarge());
        mDiscoeryRecommend12.setTagText2(hotRecommendsLists.get(11).getList().get(1).getTrackTitle());
        mDiscoeryRecommend12.setImageView3(getActivity(),hotRecommendsLists.get(11).getList().get(2).getCoverLarge());
        mDiscoeryRecommend12.setTagText3(hotRecommendsLists.get(11).getList().get(2).getTrackTitle());

        mDiscoeryRecommend13.setTitleText(hotRecommendsLists.get(12).getTitle());
        mDiscoeryRecommend13.setImageView1(getActivity(), hotRecommendsLists.get(12).getList().get(0).getCoverLarge());
        mDiscoeryRecommend13.setTagText1(hotRecommendsLists.get(12).getList().get(0).getTrackTitle());
        mDiscoeryRecommend13.setImageView2(getActivity(),hotRecommendsLists.get(12).getList().get(1).getCoverLarge());
        mDiscoeryRecommend13.setTagText2(hotRecommendsLists.get(12).getList().get(1).getTrackTitle());
        mDiscoeryRecommend13.setImageView3(getActivity(),hotRecommendsLists.get(12).getList().get(2).getCoverLarge());
        mDiscoeryRecommend13.setTagText3(hotRecommendsLists.get(12).getList().get(2).getTrackTitle());

        mDiscoeryRecommend14.setTitleText(hotRecommendsLists.get(13).getTitle());
        mDiscoeryRecommend14.setImageView1(getActivity(), hotRecommendsLists.get(13).getList().get(0).getCoverLarge());
        mDiscoeryRecommend14.setTagText1(hotRecommendsLists.get(13).getList().get(0).getTrackTitle());
        mDiscoeryRecommend14.setImageView2(getActivity(),hotRecommendsLists.get(13).getList().get(1).getCoverLarge());
        mDiscoeryRecommend14.setTagText2(hotRecommendsLists.get(13).getList().get(1).getTrackTitle());
        mDiscoeryRecommend14.setImageView3(getActivity(),hotRecommendsLists.get(13).getList().get(2).getCoverLarge());
        mDiscoeryRecommend14.setTagText3(hotRecommendsLists.get(13).getList().get(2).getTrackTitle());
    }

}
