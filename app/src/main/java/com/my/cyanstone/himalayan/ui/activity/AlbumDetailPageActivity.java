package com.my.cyanstone.himalayan.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.my.cyanstone.himalayan.R;
import com.my.cyanstone.himalayan.model.AlbumDetails;
import com.my.cyanstone.himalayan.model.EditorHotRecommendAlbumsList;
import com.my.cyanstone.himalayan.net.API;
import com.my.cyanstone.himalayan.net.MyHttpClient;
import com.my.cyanstone.himalayan.ui.fragment.DiscoveryRecommendFragment;

import java.io.IOException;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by 95199 on 2016/3/19.
 */
public class AlbumDetailPageActivity extends SwipeBackActivity {
    private static final String TAG = "AlbumDetailPageActivity";
    private EditorHotRecommendAlbumsList mExtraAlbumData;
    private int position;
    private long albumId;
    private int source;
    private int pageSize;
    private String device,title;
    private boolean isAsc;

    private AlbumDetails mAlbumDetailsData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail_page);
        getExtra();
        getJson();
    }

    private void getExtra() {
        mExtraAlbumData = getIntent().getExtras().getParcelable(DiscoveryRecommendFragment.EXTRA_RECOMMEND_ITEM_DATA);
        //position=1&albumId=322522&source=1&isAsc=true&device=android&title=听新闻&pageSize=20
        position = 1;
        albumId = mExtraAlbumData.getAlbumId();
        source = 1;
        isAsc = true;
        device = "android";
        title = getIntent().getExtras().getString(DiscoveryRecommendFragment.EXTRA_RECOMMEND_TITLE);
        pageSize = 20;
    }

    private void getJson(){
        FormBody formBody = new FormBody.Builder()
                .add("position",position + "")
                .add("albumId", albumId + "")
                .add("source",source + "")
                .add("isAsc",isAsc + "")
                .add("device",device)
                .add("title",title)
                .add("&pageSize",pageSize + "")
                .build();

        Request request = new Request.Builder()
                .url(API.ALBUM_DETAIL)
                .post(formBody)
                .build();

        MyHttpClient.getHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    Gson gson = new Gson();
                   mAlbumDetailsData = gson.fromJson(response.body().string(),AlbumDetails.class);
                    Log.d(TAG,"parse json data");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.out_from_right);
    }
}
