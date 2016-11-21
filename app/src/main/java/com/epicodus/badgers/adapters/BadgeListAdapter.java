package com.epicodus.badgers.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;

import java.util.ArrayList;

/**
 * Created by Daren on 9/29/2016.
 */

public class BadgeListAdapter extends RecyclerView.Adapter<BadgeViewHolder>  {
    private ArrayList<Badge> mBadges = new ArrayList<>();
    private Context mContext;

    public BadgeListAdapter(Context context, ArrayList<Badge> badges) {
        mContext = context;
        mBadges = badges;
    }

    @Override
    public BadgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_list_item, parent, false);
        BadgeViewHolder viewHolder = new BadgeViewHolder(mBadges, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BadgeViewHolder holder, int position) {
        holder.bindBadge(mBadges.get(position));

    }

    @Override
    public int getItemCount() {
        return mBadges.size();
    }

}
