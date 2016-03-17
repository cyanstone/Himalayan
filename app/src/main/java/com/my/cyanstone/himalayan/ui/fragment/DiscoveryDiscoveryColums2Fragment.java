package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.DiscoveryColumnsList;
import com.my.cyanstone.himalayan.ui.view.ImageTextClickListener;
import com.my.cyanstone.himalayan.ui.view.ImageTextView;
import com.my.cyanstone.himalayan.utils.ClickEvent;

import java.util.ArrayList;

/**
 * Created by 95199 on 2016/3/16.
 */
public class DiscoveryDiscoveryColums2Fragment extends Fragment {

    private ImageTextView it5,it6,it7,it8;
    private ArrayList<DiscoveryColumnsList> mLists;

    public static Fragment newInstance(ArrayList<DiscoveryColumnsList> list){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", list);
        Fragment fragment = new DiscoveryDiscoveryColums2Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLists = (ArrayList<DiscoveryColumnsList>) getArguments().getSerializable("list");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dicovery_discovery_colums2,container,false);
       init(v);
        return v;
    }

    private void init(View v) {

        it5 = (ImageTextView) v.findViewById(R.id.it5);
        it6 = (ImageTextView) v.findViewById(R.id.it6);
        it7 = (ImageTextView) v.findViewById(R.id.it7);
        it8 = (ImageTextView) v.findViewById(R.id.it8);

        it5.setText(mLists.get(4).getTitle());
        it5.setImageView(getActivity(), mLists.get(4).getCoverPath());
        it5.setOnImageTextClickListener(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(4));
            }
        });

        it6.setText(mLists.get(5).getTitle());
        it6.setImageView(getActivity(), mLists.get(5).getCoverPath());
        it6.setOnImageTextClickListener(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(5));
            }
        });

        it7.setText(mLists.get(6).getTitle());
        it7.setImageView(getActivity(), mLists.get(6).getCoverPath());
        it7.setOnImageTextClickListener(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(6));
            }
        });

        it8.setText(mLists.get(7).getTitle());
        it8.setImageView(getActivity(),mLists.get(7).getCoverPath());
        it8.setOnImageTextClickListener(new ImageTextClickListener() {
            @Override
            public void myOnClick() {
                ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(7));
            }
        });
    }
}
