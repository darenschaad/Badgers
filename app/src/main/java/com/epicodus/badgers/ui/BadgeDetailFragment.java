package com.epicodus.badgers.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BadgeDetailFragment extends Fragment {
    @BindView(R.id.badgeImageView) ImageView mImageLabel;
    @BindView(R.id.badgeNameTextView) TextView mNameLabel;
//    @BindView(R.id.tagsTextView) TextView mTagsLabel;
    @BindView(R.id.indexTextView) TextView mIndexLabel;
    @BindView(R.id.categoryTextView) TextView mCategoryLabel;
    @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.proofTextView) TextView mProofTextView;
    @BindView(R.id.saveBadgeButton) Button mSaveBadgeButton;
    @BindView(R.id.backgroundLayout) LinearLayout mBackgroundLayout;
    @BindView(R.id.backgroundLayout2) LinearLayout mBackgroundLayout2;

    private Badge mBadge;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    private static Context mContext;
    int height;

    Integer[] categories = {0,100,200,300,400,500,600,700,800,900};
    int[] categoryTextColors = {R.color.category0Text, R.color.category100Text,R.color.category200Text, R.color.category300Text, R.color.category400Text, R.color.category500Text, R.color.category600Text, R.color.category700Text, R.color.category800Text, R.color.category900Text};
    int[] categoryColors = {R.color.category0Primary, R.color.category100Primary, R.color.category200Primary, R.color.category300Primary, R.color.category400Primary, R.color.category500Primary, R.color.category600Primary, R.color.category700Primary, R.color.category800Primary, R.color.category900Primary};



    public static BadgeDetailFragment newInstance(Badge badge, Context context) {
        // Required empty public constructor
        BadgeDetailFragment badgeDetailFragment = new BadgeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("badge", Parcels.wrap(badge));
        badgeDetailFragment.setArguments(args);
        mContext = context;
        return badgeDetailFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBadge = Parcels.unwrap(getArguments().getParcelable("badge"));
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        height = size.y;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_badge_detail, container, false);
        ButterKnife.bind(this, view);

//        mAddressLabel.setOnClickListener(this);
//        if (!mBadge.getImageUrl().contains("http")) {
//            try {
//                Bitmap imageBitmap = decodeFromFirebaseBase64(mBadge.getImageUrl());
//                mImageLabel.setImageBitmap(imageBitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Picasso.with(view.getContext()).load(mBadge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mImageLabel);
//
//        }

        mNameLabel.setText(mBadge.getName());
        mIndexLabel.setText(Double.toString(mBadge.getIndex()));
        mCategoryLabel.setText(String.valueOf(mBadge.getCategory()));
//        mCategoryLabel.setText(String.valueOf(mBadge.getCategory()));
//        mCategoryLabel.setRotation(-90);
        ViewGroup.LayoutParams params = mCategoryLabel.getLayoutParams();
        params.width = height;
        mCategoryLabel.setLayoutParams(params);
        mDescriptionTextView.setText(mBadge.getDescription());
        mProofTextView.setText(mBadge.getProof());

        setColors();

        Log.d("height", ""+mCategoryLabel.getHeight());
//        mTagsLabel.setText(android.text.TextUtils.join(", ", mBadge.getTags()));
        return view;
    }

    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

//    @Override
//    public void onClick(View v) {
//        if (v == mAddressLabel) {
//            double latitude = mBadge.getLatitude();
//            double longitude = mBadge.getLongitude();
//
//            Uri location = Uri.parse("geo:" + latitude + "," + longitude + "?z=14&q=<" + latitude  + ">,<" + longitude + ">(" + mBadge.getName() + ")");
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//            startActivity(mapIntent);
//        }
//    }

    private void setColors() {
        int category = mBadge.getCategory();
        Log.d("category", category +"");
        int categoryIndex = Arrays.asList(categories).indexOf(category);
        Log.d("index", Arrays.asList(categories).get(0).toString()+"");
        int categoryTextColor = categoryTextColors[categoryIndex];
        int categoryColor = categoryColors[categoryIndex];
        mNameLabel.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        mIndexLabel.setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        setMaincolor(categoryColor);

    }

    private void setMaincolor(int categoryColor) {
        View[] backgroundViews = {mBackgroundLayout, mBackgroundLayout2};
        for (int i=0 ; i<backgroundViews.length ; i++){
            Log.d("background", backgroundViews[i] +"");
            backgroundViews[i].setBackgroundColor(ContextCompat.getColor(mContext, categoryColor));
        }
    }
}
