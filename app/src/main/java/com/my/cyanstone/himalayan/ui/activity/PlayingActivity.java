package com.my.cyanstone.himalayan.ui.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.ui.fragment.PlayingFragment;

/**
 * Created by 95199 on 2016/3/10.
 */
public class PlayingActivity extends AppCompatActivity {
    private static final String TAG = "PlayingActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "step in onCreater()");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "super.onCreate() end");
        setContentView(R.layout.activity_fragment);
        Log.d(TAG, "setContentView() end");
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_fragment_container);
        if(fragment == null) {
            fragment = new PlayingFragment();
            fm.beginTransaction()
                    .add(R.id.activity_fragment_container,fragment)
                    .commit();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_bottom,R.anim.out_from_bottom);
    }
}
