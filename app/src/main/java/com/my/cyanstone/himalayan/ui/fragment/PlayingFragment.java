package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.cyanstone.himalayan.R;

/**
 * Created by 95199 on 2016/3/10.
 */
public class PlayingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playing,container,false);
        return  v;
    }
}
