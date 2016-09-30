package com.epicodus.badgers.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.badgers.R;

import com.epicodus.badgers.models.Badge;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daren on 9/29/2016.
 */

public class BadgeListAdapter extends RecyclerView.Adapter<BadgeListAdapter.BadgeViewHolder> {
    private ArrayList<Badge> mBadges = new ArrayList<>();
    private Context mContext;

    public BadgeListAdapter(Context context, ArrayList<Badge> badges) {
        mContext = context;
        mBadges = badges;
    }

    @Override
    public BadgeListAdapter.BadgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_list_item, parent, false);
        BadgeViewHolder viewHolder = new BadgeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BadgeListAdapter.BadgeViewHolder holder, int position) {
        holder.bindBadge(mBadges.get(position));

    }

    @Override
    public int getItemCount() {
        return mBadges.size();
    }


    public class BadgeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.badgeImageView) ImageView mBadgeImageView;
        @BindView(R.id.badgeNameTextView) TextView mNameTextView;
        @BindView(R.id.tagTextView) TextView mTagTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public BadgeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBadge(Badge badge) {
            mNameTextView.setText(badge.getName());
            mTagTextView.setText(badge.getTags().get(0));
            mRatingTextView.setText("Rating: " + badge.getRating() + "/5");
        }
    }
}
