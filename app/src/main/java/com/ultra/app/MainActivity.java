package com.ultra.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ultra.app.fragment.FourFragment;
import com.ultra.app.fragment.OneFragment;
import com.ultra.app.fragment.ThreeFragment;
import com.ultra.app.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        initWithData();
    }

    private void initWithData() {
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        viewPager.setAdapter(new Adapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);
    }

    private class Adapter extends FragmentPagerAdapter {


        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
