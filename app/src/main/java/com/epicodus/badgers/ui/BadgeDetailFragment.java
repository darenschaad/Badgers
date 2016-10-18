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
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;

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

    private Badge mBadge;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    private static Context mContext;
    int height;



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
        if(category == 0){
            mNameLabel.setTextColor(ContextCompat.getColor(mContext, R.color.category0Text));
        }

    }
}
