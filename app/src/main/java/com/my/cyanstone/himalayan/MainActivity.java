package com.my.cyanstone.himalayan;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.my.cyanstone.himalayan.ui.activity.PlayingActivity;
import com.my.cyanstone.himalayan.ui.fragment.CustomizationFragment;
import com.my.cyanstone.himalayan.ui.fragment.DownloadFragment;
import com.my.cyanstone.himalayan.ui.fragment.DiscoveryFragment;
import com.my.cyanstone.himalayan.ui.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup tabRadioGroup;
    private RadioButton tabFindBtn;
    private ImageView playImgView;
    private FragmentManager fm;
    private Fragment findFragment,customizationFragment,downloadFragment,meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        fm = getSupportFragmentManager();
        tabRadioGroup = (RadioGroup) findViewById(R.id.tab_radioGroup);
        tabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                hideAllFragment(fragmentTransaction);
                switch (checkedId) {
                    case R.id.tab_find:
                        if (findFragment == null) {
                            findFragment = new DiscoveryFragment();
                            fragmentTransaction.add(R.id.fragment_container, findFragment);
                        } else {
                            fragmentTransaction.show(findFragment);
                        }
                        break;

                    case R.id.tab_customization:
                        if (customizationFragment == null) {
                            customizationFragment = new CustomizationFragment();
                            fragmentTransaction.add(R.id.fragment_container, customizationFragment);
                        } else {
                            fragmentTransaction.show(customizationFragment);
                        }
                        break;
                    case R.id.tab_download:
                        if (downloadFragment == null) {
                            downloadFragment = new DownloadFragment();
                            fragmentTransaction.add(R.id.fragment_container, downloadFragment);
                        } else {
                            fragmentTransaction.show(downloadFragment);
                        }
                        break;
                    case R.id.tab_me:
                        if (meFragment == null) {
                            meFragment = new MeFragment();
                            fragmentTransaction.add(R.id.fragment_container, meFragment);
                        } else {
                            fragmentTransaction.show(meFragment);
                        }
                        break;
                }
                fragmentTransaction.commit();
            }
        });
        tabFindBtn = (RadioButton) findViewById(R.id.tab_find);
        tabFindBtn.setChecked(true);

        playImgView = (ImageView) findViewById(R.id.tab_play_imgBnt);
        playImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_bottom,R.anim.out_from_bottom);
            }
        });
    }

    private void hideAllFragment(FragmentTransaction ft){
        if(findFragment != null) ft.hide(findFragment);
        if(customizationFragment != null) ft.hide(customizationFragment);
        if(downloadFragment != null) ft.hide(downloadFragment);
        if(meFragment != null) ft.hide(meFragment);
    }
}
