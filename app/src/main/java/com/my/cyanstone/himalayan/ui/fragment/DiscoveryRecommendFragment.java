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
import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.DiscoveryRecommend;
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;
import com.my.cyanstone.himalayan.model.FocusImagesList;
import com.my.cyanstone.himalayan.model.HotRecommendsList;
import com.my.cyanstone.himalayan.net.API;
import com.my.cyanstone.himalayan.net.MyHttpClient;
import com.my.cyanstone.himalayan.ui.view.DiscoveryRecommendView;
import com.my.cyanstone.himalayan.ui.view.FocusBannerHolderView;
import com.my.cyanstone.himalayan.ui.view.ImageTextClickListener;
import com.my.cyanstone.himalayan.utils.ClickEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private ViewPager mDiscoveryColumsPagers;

    private DiscoveryRecommendView mDiscoveryRecommendItem1,mDiscoveryRecommendItem2,mDiscoveryRecommendItem3,mDiscoveryRecommendItem4,mDiscoveryRecommendItem5
    ,mDiscoveryRecommendItem6,mDiscoveryRecommendItem7,mDiscoveryRecommendItem8,mDiscoveryRecommendItem9,mDiscoveryRecommendItem10,mDiscoveryRecommendItem11,mDiscoveryRecommendItem12
    ,mDiscoveryRecommendItem13,mDiscoveryRecommendItem14;
    private List<HotRecommendsList> hotRecommendsLists;

    private DiscoveryRecommendView mEditorRecommend;
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
                            initEditorRecommend(v);
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

        mDiscoveryColumsPagers = (ViewPager) v.findViewById(R.id.dicovery_view_Pager);
        mDiscoveryColumsPagers.setOffscreenPageLimit(2);
        mDiscoveryColumsPagers.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager() ) {
            @Override
            public Fragment getItem(int position) {
                return mDiscoveryColumsFragments.get(position);
            }

            @Override
            public int getCount() {
                return mDiscoveryColumsFragments.size();
            }
        });
        mDiscoveryColumsPagers.setBackgroundResource(R.color.tab_background);
    }

    private void initHotRecommends(View v) {
        mDiscoveryRecommendItem1 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view1);
        mDiscoveryRecommendItem2 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view2);
        mDiscoveryRecommendItem3 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view3);
        mDiscoveryRecommendItem4 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view4);
        mDiscoveryRecommendItem5 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view5);
        mDiscoveryRecommendItem6 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view6);
        mDiscoveryRecommendItem7 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view7);
        mDiscoveryRecommendItem8 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view8);
        mDiscoveryRecommendItem9 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view9);
        mDiscoveryRecommendItem10 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view10);
        mDiscoveryRecommendItem11 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view11);
        mDiscoveryRecommendItem12 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view12);
        mDiscoveryRecommendItem13 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view13);
        mDiscoveryRecommendItem14 = (DiscoveryRecommendView) v.findViewById(R.id.discovery_recommend_view14);

        hotRecommendsLists = mDiscoveryRecommend.getHotRecommends().getList();
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem1, hotRecommendsLists.get(0));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem2, hotRecommendsLists.get(1));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem3, hotRecommendsLists.get(2));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem4, hotRecommendsLists.get(3));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem5, hotRecommendsLists.get(4));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem6, hotRecommendsLists.get(5));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem7, hotRecommendsLists.get(6));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem8, hotRecommendsLists.get(7));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem9, hotRecommendsLists.get(8));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem10, hotRecommendsLists.get(9));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem11, hotRecommendsLists.get(10));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem12, hotRecommendsLists.get(11));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem13, hotRecommendsLists.get(12));
        discoveryRecommendViewInitUtil(mDiscoveryRecommendItem14, hotRecommendsLists.get(13));
    }

    private void initEditorRecommend(View v) {
        mEditorRecommend = (DiscoveryRecommendView) v.findViewById(R.id.discovery_editor_recommends);
        final ArrayList<EditorHotRecommendAlbumsList> list = (ArrayList<EditorHotRecommendAlbumsList>) mDiscoveryRecommend.getEditorRecommendAlbums().getList();
        mEditorRecommend.setTitleText(mDiscoveryRecommend.getEditorRecommendAlbums().getTitle());
        mEditorRecommend.setImageView1(getActivity(),list.get(0).getCoverLarge());
        mEditorRecommend.setTagText1(list.get(0).getTrackTitle());
        mEditorRecommend.setOnListener1(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(),list.get(0));
            }
        });

        mEditorRecommend.setImageView2(getActivity(), list.get(1).getCoverLarge());
        mEditorRecommend.setTagText2(list.get(1).getTrackTitle());
        mEditorRecommend.setOnListener2(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(),list.get(1));
            }
        });

        mEditorRecommend.setImageView3(getActivity(), list.get(2).getCoverLarge());
        mEditorRecommend.setTagText3(list.get(2).getTrackTitle());
        mEditorRecommend.setOnListener3(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(),list.get(2));
            }
        });

        mEditorRecommend.setOnMoreClickListener(new DiscoveryRecommendView.MoreClickListener() {
            @Override
            public void moreClick() {
                ClickEvent.DiscoveryEditorRecommendMoreClick(getActivity(), mDiscoveryRecommend.getEditorRecommendAlbums());
            }
        });
    }

    private void discoveryRecommendViewInitUtil(DiscoveryRecommendView view, final HotRecommendsList item) {
        view.setTitleText(item.getTitle());
        view.setImageView1(getActivity(), item.getList().get(0).getCoverLarge());
        view.setTagText1(item.getList().get(0).getTrackTitle());
        view.setOnListener1(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(), item.getList().get(0));
            }
        });

        view.setImageView2(getActivity(), item.getList().get(1).getCoverLarge());
        view.setTagText2(item.getList().get(1).getTrackTitle());
        view.setOnListener2(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(), item.getList().get(1));
            }
        });
        view.setImageView3(getActivity(), item.getList().get(2).getCoverLarge());
        view.setTagText3(item.getList().get(2).getTrackTitle());
        view.setOnListener3(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DiscoveryHotRecommendsClick(getActivity(), item.getList().get(2));
            }
        });

        view.setOnMoreClickListener(new DiscoveryRecommendView.MoreClickListener() {
            @Override
            public void moreClick() {
                ClickEvent.DiscoveryHotRecommendsMoreClick(getActivity(),item);
            }
        });

    }

}
