package com.epicodus.badgers.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.badgers.models.Badge;
import com.epicodus.badgers.ui.BadgeDetailFragment;

import java.util.ArrayList;

/**
 * Created by Daren on 10/4/2016.
 */

public class BadgePagerAdapter  extends FragmentPagerAdapter{
    private ArrayList<Badge> mBadges;
    private Context mContext;

    public BadgePagerAdapter(FragmentManager fm, ArrayList<Badge> badges, Context context) {
        super(fm);
        mBadges = badges;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return BadgeDetailFragment.newInstance(mBadges.get(position), mContext);
    }

    @Override
    public int getCount() {
        return mBadges.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBadges.get(position).getName();
    }

}
