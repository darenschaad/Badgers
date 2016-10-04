package com.epicodus.badgers.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.epicodus.badgers.R;
import com.epicodus.badgers.adapters.BadgePagerAdapter;
import com.epicodus.badgers.models.Badge;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BadgeDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private BadgePagerAdapter adapterViewPager;
    ArrayList<Badge> mBadges = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_detail);
        ButterKnife.bind(this);

        mBadges = Parcels.unwrap(getIntent().getParcelableExtra("badges"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BadgePagerAdapter(getSupportFragmentManager(), mBadges);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
