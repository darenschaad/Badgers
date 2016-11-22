package com.epicodus.badgers.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
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
    @BindView(R.id.deweyTextView) TextView mDeweyTextView;
    @BindView(R.id.smallDescriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.listBackground) LinearLayout mListBackground;
    @BindView(R.id.badgeListCategory) TextView mBadgeListCategory;

    private ArrayList<Badge> mBadges = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    double height;
    double width;

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
        mNameTextView.setText(badge.getName());

        Typeface futura = Typeface.createFromAsset(mContext.getAssets(),"fonts/futura-condensed-normal.ttf");
        Typeface bebas = Typeface.createFromAsset(mContext.getAssets(),"fonts/bebas.otf");
        mDescriptionTextView.setTypeface(futura);
        mBadgeListCategory.setTypeface(futura);
        mNameTextView.setTypeface(bebas);
        mDeweyTextView.setTypeface(bebas);

        int category = badge.getCategory();
        int categoryIndex = Arrays.asList(categories).indexOf(category);
        int categoryTextColor = categoryTextColors[categoryIndex];
        int categoryColor = categoryColors[categoryIndex];
        mBadgeListCategory.setText(categoryText[categoryIndex]);
        mDeweyTextView.setText(badge.getIndex().substring(1));
        mNameTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mDescriptionTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mBadgeListCategory.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mDeweyTextView.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mListBackground.setBackgroundColor(ContextCompat.getColor(mContext,categoryColor));

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;
        Log.d("screenWidth", width + "");

        if (width < 750){
            mBadgeImageView.getLayoutParams().width = 200;
            mBadgeImageView.getLayoutParams().height = 200;
            mBadgeListCategory.setTextSize(13);
            mDeweyTextView.setTextSize(13);
            mNameTextView.setTextSize(20);
            if (badge.getDescription().length() < 70){
                String descrip = badge.getDescription();
                mDescriptionTextView.setText(descrip);
            } else {
                String descrip = badge.getDescription().substring(0,70)  + "...";
                mDescriptionTextView.setText(descrip);
            }
        } else {
            if (badge.getDescription().length() < 100){
                String descrip = badge.getDescription();
                mDescriptionTextView.setText(descrip);
            } else {
                String descrip = badge.getDescription().substring(0,100)  + "...";
                mDescriptionTextView.setText(descrip);
            }
        }

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