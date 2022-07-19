package com.example.odstest6.viewPager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.odstest6.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Tab2Activity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    MyPagerAdapter2 myPagerAdapter2;
    BadgeDrawable badgeDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager2);

        myPagerAdapter2=new MyPagerAdapter2(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(myPagerAdapter2);

        tabLayout.addTab(tabLayout.newTab().setText("one"));
        tabLayout.addTab(tabLayout.newTab().setText("Two"));

        /*tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });*/

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
                    case 0:
                        tab.setIcon(R.drawable.android);
                        tab.setText("Android Java");
                        badgeDrawable=tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.teal_700));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(50);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    case 1:

                        tab.setIcon(R.drawable.android);
                        tab.setText("Android Kotlin");
                        badgeDrawable=tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.teal_700));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(50);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                }

            }
        });

        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                badgeDrawable=tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

    }
}