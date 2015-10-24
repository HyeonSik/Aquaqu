package com.nexters.aquaqu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nexters.aquaqu.activity.SplashActivity;
import com.nexters.aquaqu.adapter.MainAdapter;

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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_logo_24dp);
        toolbar.setBackgroundColor(getResources().getColor(R.color.ctrans));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        startActivity(new Intent(mContext, SplashActivity.class));
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
            case R.id.action_settings:
                break;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
