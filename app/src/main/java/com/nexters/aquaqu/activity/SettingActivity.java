package com.nexters.aquaqu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexters.aquaqu.R;
import com.nexters.aquaqu.util.PreferenceManager;

/**
 * Created by HyunSik on 2015-10-24.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView start00;
    ImageView start01;
    ImageView start02;
    ImageView start03;
    ImageView start04;
    ImageView start05;
    ImageView start06;
    ImageView start07;
    ImageView start08;
    ImageView start09;
    ImageView start10;
    TextView setting_name;
    ImageView setting_exit;

    boolean selected = false;

    int img_selected = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_activity_setting);

        start00 = (ImageView) findViewById(R.id.start00);
        start01 = (ImageView) findViewById(R.id.start01);
        start02 = (ImageView) findViewById(R.id.start02);
        start03 = (ImageView) findViewById(R.id.start03);
        start04 = (ImageView) findViewById(R.id.start04);
        start05 = (ImageView) findViewById(R.id.start05);
        start06 = (ImageView) findViewById(R.id.start06);
        start07 = (ImageView) findViewById(R.id.start07);
        start08 = (ImageView) findViewById(R.id.start08);
        start09 = (ImageView) findViewById(R.id.start09);
        start10 = (ImageView) findViewById(R.id.start10);
        setting_name = (TextView) findViewById(R.id.setting_name);
        setting_exit = (ImageView) findViewById(R.id.setting_exit);


        start00.setOnClickListener(this);
        start01.setOnClickListener(this);
        start02.setOnClickListener(this);
        start03.setOnClickListener(this);
        start04.setOnClickListener(this);
        start05.setOnClickListener(this);
        start06.setOnClickListener(this);
        start07.setOnClickListener(this);
        start08.setOnClickListener(this);
        start09.setOnClickListener(this);
        start10.setOnClickListener(this);
        setting_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        start00.setImageResource(R.drawable.ic_star_36dp);
        start01.setImageResource(R.drawable.ic_star_36dp);
        start02.setImageResource(R.drawable.ic_star_36dp);
        start03.setImageResource(R.drawable.ic_star_36dp);
        start04.setImageResource(R.drawable.ic_star_36dp);
        start05.setImageResource(R.drawable.ic_star_36dp);
        start06.setImageResource(R.drawable.ic_star_36dp);
        start07.setImageResource(R.drawable.ic_star_36dp);
        start08.setImageResource(R.drawable.ic_star_36dp);
        start09.setImageResource(R.drawable.ic_star_36dp);
        start10.setImageResource(R.drawable.ic_star_36dp);
        switch (v.getId()) {
            case R.id.start00:
                start00.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 0;
                setting_name.setText(getResources().getString(R.string.zero));
                break;
            case R.id.start01:
                start01.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 1;
                setting_name.setText(getResources().getString(R.string.one));
                break;
            case R.id.start02:
                start02.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 2;
                setting_name.setText(getResources().getString(R.string.two));
                break;
            case R.id.start03:
                start03.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 3;
                setting_name.setText(getResources().getString(R.string.three));
                break;
            case R.id.start04:
                start04.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 4;
                setting_name.setText(getResources().getString(R.string.four));
                break;
            case R.id.start05:
                start05.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 5;
                setting_name.setText(getResources().getString(R.string.five));
                break;
            case R.id.start06:
                start06.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 6;
                setting_name.setText(getResources().getString(R.string.six));
                break;
            case R.id.start07:
                start07.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 7;
                setting_name.setText(getResources().getString(R.string.seven));
                break;
            case R.id.start08:
                start08.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 8;
                setting_name.setText(getResources().getString(R.string.eight));
                break;
            case R.id.start09:
                start09.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 9;
                setting_name.setText(getResources().getString(R.string.nine));
                break;
            case R.id.start10:
                start10.setImageResource(R.drawable.ic_star_on_36dp);
                img_selected = 10;
                setting_name.setText(getResources().getString(R.string.ten));
                break;
            case R.id.setting_exit:
                PreferenceManager.getInstance(SettingActivity.this).setSelectedstar(img_selected);
                setResult(RESULT_OK);
//                Toast.makeText(SettingActivity.this, PreferenceManager.getInstance(SettingActivity.this).getSelectedstar()+"", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
