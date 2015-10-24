package com.nexters.aquaqu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nexters.aquaqu.R;
import com.nexters.aquaqu.activity.ArticleActivity;
import com.nexters.aquaqu.helper.OceanHelper;

import net.htmlparser.jericho.Source;

/**
 * Created by HyunSik on 2015-10-25.
 */
public class SixFragment extends Fragment {

    private Source source;
    OceanHelper helper = new OceanHelper();
    TextView info, weather, temp, wind, sea, water, height;

    private static final String TAG = "SixFragment";

    public static SixFragment newInstance() {
        SixFragment fragment = new SixFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.l_activity_viewpager, container, false);
        rootView.setTag(TAG);

        TextView name = (TextView) rootView.findViewById(R.id.pager01_name);
        info = (TextView) rootView.findViewById(R.id.pager01_desc);
        weather = (TextView) rootView.findViewById(R.id.aqu_weather01);
        temp = (TextView) rootView.findViewById(R.id.aqu_temp01);
        wind = (TextView) rootView.findViewById(R.id.aqu_wind01);
        sea = (TextView) rootView.findViewById(R.id.aqu_sea01);
        water = (TextView) rootView.findViewById(R.id.aqu_water01);
        height = (TextView) rootView.findViewById(R.id.aqu_height01);

        name.setText(getResources().getString(R.string.six));

        weather.setText("17 ℃");
        temp.setText("20.1 ℃");
        wind.setText("북북동2.6 m/s");
        sea.setText("92cm");
        water.setText("22.17 ℃");
        height.setText("0.45m");

        info.setText("카약, 수상스키, 서핑 등의 다양한 수상레저활동을 즐길 수 있는 곳!");

        rootView.findViewById(R.id.pager_news_item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                intent.putExtra("img_", "@drawable/article1");
                getActivity().startActivity(intent);
            }
        });

        rootView.findViewById(R.id.pager_news_item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                intent.putExtra("img_", "@drawable/article2");
                getActivity().startActivity(intent);
            }
        });

        rootView.findViewById(R.id.pager_news_item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                intent.putExtra("img_", "@drawable/article3");
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
