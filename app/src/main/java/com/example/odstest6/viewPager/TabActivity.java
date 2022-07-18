package com.example.odstest6.viewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.odstest6.R;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    int[] images={R.drawable.ic_baseline_arrow_back_24,R.drawable.ic_baseline_arrow_back_24,R.drawable.ic_baseline_arrow_back_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(images[0]);
        tabLayout.getTabAt(1).setIcon(images[1]);
        tabLayout.getTabAt(2).setIcon(images[2]);

    }
}