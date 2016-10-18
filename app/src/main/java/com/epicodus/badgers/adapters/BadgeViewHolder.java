package com.epicodus.badgers.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.epicodus.badgers.ui.BadgeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daren on 10/12/2016.
 */

public class BadgeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.badgeImageView) ImageView mBadgeImageView;
    @BindView(R.id.badgeNameTextView) TextView mNameTextView;
//    @BindView(R.id.categoryTextView) TextView mCategoryTextView;
    @BindView(R.id.tagTextView) TextView mTagTextView;


    private ArrayList<Badge> mBadges = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    public BadgeViewHolder(ArrayList<Badge> badges, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mBadges = badges;
        itemView.setOnClickListener(this);
    }

    public void bindBadge(Badge badge) {
//        if (!badge.getImageUrl().contains("http")) {
//            try {
//                Bitmap imageBitmap = decodeFromFirebaseBase64(badge.getImageUrl());
//                mBadgeImageView.setImageBitmap(imageBitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Picasso.with(itemView.getContext()).load(badge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mBadgeImageView);
//
//        }
        mNameTextView.setText(badge.getName());

//        mCategoryTextView.setText(String.valueOf(badge.getCategory()));
//        mCategoryTextView.setRotation(-90);
//        mTagTextView.setText(badge.getTags().get(0));

    }

    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }



    @Override
    public void onClick(View v) {
        int itemPosition = getLayoutPosition();
        Intent intent = new Intent(mContext, BadgeDetailActivity.class);
        intent.putExtra("position", itemPosition);
        intent.putExtra("badges", Parcels.wrap(mBadges));
        mContext.startActivity(intent);
    }
}