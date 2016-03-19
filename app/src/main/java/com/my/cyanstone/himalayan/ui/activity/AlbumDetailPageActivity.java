package com.my.cyanstone.himalayan.ui.activity;

import android.os.Bundle;

import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by 95199 on 2016/3/19.
 */
public class AlbumDetailPageActivity extends SwipeBackActivity {
    private static final String TAG = "AlbumDetailPageActivity";
    private EditorHotRecommendAlbumsList mAlbumData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail_page);
        mAlbumData = getIntent().getExtras().getParcelable("data");
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.out_from_right);
    }
}
