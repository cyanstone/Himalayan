package com.my.cyanstone.himalayan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.cyanstone.himalayan.R;

/**
 * Created by 95199 on 2016/1/17.
 */
public class DiscoveryHostFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discovery_host,container,false);
        return v;
    }
}
