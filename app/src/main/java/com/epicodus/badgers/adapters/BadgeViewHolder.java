package com.epicodus.badgers.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epicodus.badgers.R;

import com.epicodus.badgers.models.Badge;
import com.epicodus.badgers.ui.AllBadgeActivity;
import com.epicodus.badgers.ui.BadgeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daren on 10/12/2016.
 */

public class BadgeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.badgeImageView) ImageView mBadgeImageView;
    @BindView(R.id.badgeNameTextView) TextView mNameTextView;
    @BindView(R.id.ratingTextView) TextView mRatingTextView;
    @BindView(R.id.smallDescriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.listBackground) LinearLayout mListBackground;
    @BindView(R.id.badgeListCategory) TextView mBadgeListCategory;

    private ArrayList<Badge> mBadges = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    Integer[] categories = {0,100,200,300,400,500,600,700,800,900};
    int[] categoryTextColors = {R.color.category0Text, R.color.category100Text,R.color.category200Text, R.color.category300Text, R.color.category400Text, R.color.category500Text, R.color.category600Text, R.color.category700Text, R.color.category800Text, R.color.category900Text};
    int[] categoryColors = {R.color.category0Primary, R.color.category100Primary, R.color.category200Primary, R.color.category300Primary, R.color.category400Primary, R.color.category500Primary, R.color.category600Primary, R.color.category700Primary, R.color.category800Primary, R.color.category900Primary};
    String[] categoryText = {"000 - GENERAL KNOWLEDGE", "100 - PHILOSOPHY & PSYCHOLOGY", "200 - RELIGION", "300 - SOCIAL SCIENCE", "400 - LANGUAGES", "500 - SCIENCE", "600 - TECHNOLOGY", "700 - ARTS & RECREATION", "800 - LITERATURE", "900 - HISTORY & GEOGRAPHY"};

    public BadgeViewHolder(ArrayList<Badge> badges, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mBadges = badges;
        itemView.setOnClickListener(this);
    }

    public void bindBadge(Badge badge) {
        Picasso.with(itemView.getContext()).load(badge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mBadgeImageView);
//        if (!badge.getImageUrl().contains("http")) {
//            try {
//                Bitmap imageBitmap = decodeFromFirebaseBase64(badge.getImageUrl());
//                mBadgeImageView.setImageBitmap(imageBitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Picasso.with(itemView.getContext()).load(badge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mBadgeImageView);
//        }
        mNameTextView.setText(badge.getName());
        if (badge.getDescription().length() < 120){
            String descrip = badge.getDescription();
            mDescriptionTextView.setText(descrip);
        } else {
            String descrip = badge.getDescription().substring(0,120)  + "...";
            mDescriptionTextView.setText(descrip);
        }
        Typeface futura = Typeface.createFromAsset(mContext.getAssets(),"fonts/futura-condensed-normal.ttf");
        Typeface bebas = Typeface.createFromAsset(mContext.getAssets(),"fonts/bebas.otf");
        mDescriptionTextView.setTypeface(futura);
        mBadgeListCategory.setTypeface(futura);
        mNameTextView.setTypeface(bebas);
        mRatingTextView.setTypeface(bebas);

//        mCategoryTextView.setText(String.valueOf(badge.getCategory()));
//        mCategoryTextView.setRotation(-90);
//        mTagTextView.setText(badge.getTags().get(0));
        int category = badge.getCategory();
        int categoryIndex = Arrays.asList(categories).indexOf(category);
        int categoryTextColor = categoryTextColors[categoryIndex];
        int categoryColor = categoryColors[categoryIndex];
        mBadgeListCategory.setText(categoryText[categoryIndex]);
        mRatingTextView.setText(badge.getIndex().substring(1));
        mNameTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mDescriptionTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mRatingTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mListBackground.setBackgroundColor(ContextCompat.getColor(mContext,categoryColor));
//        if (!badge.getImageUrl().contains("http:") && !badge.getImageUrl().contains("https:")) {
//            try {
//                Bitmap imageBitmap = decodeFromFirebaseBase64(badge.getImageUrl());
//                mBadgeImageView.setImageBitmap(imageBitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else if (!badge.getImageUrl().equals("")) {
//            Picasso.with(mContext).load(badge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mBadgeImageView);
//        }
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