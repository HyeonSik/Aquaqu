package com.nexters.aquaqu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nexters.aquaqu.activity.SettingActivity;
import com.nexters.aquaqu.activity.SplashActivity;
import com.nexters.aquaqu.adapter.MainAdapter;
import com.nexters.aquaqu.util.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    MainAdapter mAdapter;

    Context mContext;

    ViewPager mViewPager;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        mViewPager.setCurrentItem(PreferenceManager.getInstance(mContext).getSelectedstar());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_logo_36dp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"제주 해양 경찰서로 전화걸기!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:064-766-2119"));
                startActivity(intent);
            }
        });

        startActivity(new Intent(mContext, SplashActivity.class));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 2) {
            mViewPager.setCurrentItem(PreferenceManager.getInstance(mContext).getSelectedstar());

        }
    }

    private long backKeyPressedTime = 0;

    @Override
    public void onBackPressed() {
        closAppDialog();
    }

    public void closAppDialog() {
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            super.onBackPressed();
            finish();
        } else {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(mContext, getResources().getString(R.string.close_app), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_setup:
                Intent intent = new Intent(mContext, SettingActivity.class);
                startActivityForResult(intent, 2);
                break;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
