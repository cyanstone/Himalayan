package com.my.cyanstone.himalayan.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.my.cyanstone.himalayan.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by 95199 on 2016/3/10.
 */
public class SearchActivity extends SwipeBackActivity {
    private final static String TAG = "SearchActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "step in onCreater()");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "super.onCreate() end");
        setContentView(R.layout.fragment_discovery_classify);
        Log.d(TAG, "setContentView() end");
    }

    @Override
    public void finish() {
        super.finish();
       // overridePendingTransition(R.anim.out_from_right,R.anim.in_from_right);
    }
}
