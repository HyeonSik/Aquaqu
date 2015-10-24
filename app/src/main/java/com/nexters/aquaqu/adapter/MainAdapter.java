package com.nexters.aquaqu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nexters.aquaqu.fragment.EightFragment;
import com.nexters.aquaqu.fragment.FiveFragment;
import com.nexters.aquaqu.fragment.FourFragment;
import com.nexters.aquaqu.fragment.NineFragment;
import com.nexters.aquaqu.fragment.OneFragment;
import com.nexters.aquaqu.fragment.SevenFragment;
import com.nexters.aquaqu.fragment.SixFragment;
import com.nexters.aquaqu.fragment.TenFragment;
import com.nexters.aquaqu.fragment.ThreeFragment;
import com.nexters.aquaqu.fragment.TwoFragment;
import com.nexters.aquaqu.fragment.ZeroFragment;

/**
 * Created by HyunSik on 2015-10-24.
 */
public class MainAdapter extends FragmentStatePagerAdapter {


    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ZeroFragment.newInstance();
            case 1:
                return OneFragment.newInstance();
            case 2:
                return TwoFragment.newInstance();
            case 3:
                return ThreeFragment.newInstance();
            case 4:
                return FourFragment.newInstance();
            case 5:
                return FiveFragment.newInstance();
            case 6:
                return SixFragment.newInstance();
            case 7:
                return SevenFragment.newInstance();
            case 8:
                return EightFragment.newInstance();
            case 9:
                return NineFragment.newInstance();
            case 10:
                return TenFragment.newInstance();
            default:
                return ZeroFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 11;
    }
}
