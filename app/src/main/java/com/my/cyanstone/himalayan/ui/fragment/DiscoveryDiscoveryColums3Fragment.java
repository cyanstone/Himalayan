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

import java.util.ArrayList;

/**
 * Created by 95199 on 2016/3/16.
 */
public class DiscoveryDiscoveryColums3Fragment extends Fragment {

    private ImageTextView it9,it10;
    private ImageTextClickListener mClickListener;
    private ArrayList<DiscoveryColumnsList> mLists;

    public static Fragment newInstance(ArrayList<DiscoveryColumnsList> list){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", list);
        Fragment fragment = new DiscoveryDiscoveryColums3Fragment();
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
        View v = inflater.inflate(R.layout.fragment_dicovery_discovery_colums3,container,false);
        init(v);
        return v;
    }

    private void init(View v) {
        mClickListener = new ImageTextClickListener() {
            @Override
            public void myOnClick() {

            }
        };
        it9 = (ImageTextView) v.findViewById(R.id.it9);
        it10 = (ImageTextView) v.findViewById(R.id.it10);

        it9.setText(mLists.get(8).getTitle());
        it9.setImageView(getActivity(), mLists.get(8).getCoverPath());
        it9.setOnImageTextClickListener(mClickListener,mLists.get(8));

        it10.setText(mLists.get(9).getTitle());
        it10.setImageView(getActivity(),mLists.get(9).getCoverPath());
        it10.setOnImageTextClickListener(mClickListener,mLists.get(9));
    }
}
