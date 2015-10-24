package com.nexters.aquaqu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nexters.aquaqu.R;

/**
 * Created by HyunSik on 2015-10-25.
 */
public class ArticleActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_activity_article);

        String img_ = getIntent().getStringExtra("img_");

        String packName = this.getPackageName(); // 패키지명
        int resID = getResources().getIdentifier(img_, "drawable", packName);

        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageResource(resID);
    }
}
