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
    private int positon,albumId,source,pageSize;
    private String device,title;
    private boolean isAsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail_page);
        mAlbumData = getIntent().getExtras().getParcelable("data");
        //position=1&albumId=322522&source=1&isAsc=true&device=android&title=听新闻&pageSize=20
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.out_from_right);
    }
}
