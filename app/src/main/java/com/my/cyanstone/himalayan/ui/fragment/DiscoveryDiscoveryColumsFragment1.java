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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95199 on 2016/3/16.
 */
public class DiscoveryDiscoveryColumsFragment1 extends Fragment {

    private ImageTextView it1,it2,it3,it4;
    private ImageTextClickListener mClickListener;
    private ArrayList<DiscoveryColumnsList> mLists;

    public static Fragment newInstance(List<DiscoveryColumnsList> list){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) list);
        Fragment fragment = new DiscoveryDiscoveryColumsFragment1();
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
        View v = inflater.inflate(R.layout.fragment_dicovery_discovery_colums1,container,false);
        init(v);
        return v;
    }

   private void init(View v) {

       mClickListener = new ImageTextClickListener() {
           @Override
           public void myOnClick() {

           }
       };
       it1 = (ImageTextView) v.findViewById(R.id.it1);
       it2 = (ImageTextView) v.findViewById(R.id.it2);
       it3 = (ImageTextView) v.findViewById(R.id.it3);
       it4 = (ImageTextView) v.findViewById(R.id.it4);

       it1.setText(mLists.get(0).getTitle());
       it1.setImageView(getActivity(), mLists.get(0).getCoverPath());
       it1.setOnImageTextClickListener(new ImageTextClickListener() {
           @Override
           public void myOnClick() {
               ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(0));
           }
       });

       it2.setText(mLists.get(1).getTitle());
       it2.setImageView(getActivity(), mLists.get(1).getCoverPath());
       it2.setOnImageTextClickListener(new ImageTextClickListener() {
           @Override
           public void myOnClick() {
               ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(1));
           }
       });

       it3.setText(mLists.get(2).getTitle());
       it3.setImageView(getActivity(), mLists.get(2).getCoverPath());
       it3.setOnImageTextClickListener(new ImageTextClickListener() {
           @Override
           public void myOnClick() {
               ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(2));
           }
       });

       it4.setText(mLists.get(3).getTitle());
       it4.setImageView(getActivity(),mLists.get(3).getCoverPath());
       it4.setOnImageTextClickListener(new ImageTextClickListener() {
           @Override
           public void myOnClick() {
               ClickEvent.DicoveryColumsClick(getActivity(), mLists.get(3));
           }
       });


    }
}
