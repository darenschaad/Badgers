package com.epicodus.badgers.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BadgeDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.badgeImageView) ImageView mImageLabel;
    @BindView(R.id.badgeNameTextView) TextView mNameLabel;
    @BindView(R.id.tagsTextView) TextView mTagsLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveBadgeButton) Button mSaveBadgeButton;

    private Badge mBadge;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;



    public static BadgeDetailFragment newInstance(Badge badge) {
        // Required empty public constructor
        BadgeDetailFragment badgeDetailFragment = new BadgeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("badge", Parcels.wrap(badge));
        badgeDetailFragment.setArguments(args);
        return badgeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBadge = Parcels.unwrap(getArguments().getParcelable("badge"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_badge_detail, container, false);
        ButterKnife.bind(this, view);

        mAddressLabel.setOnClickListener(this);

        Picasso.with(view.getContext()).load(mBadge.getImageUrl()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(mImageLabel);
        mNameLabel.setText(mBadge.getName());
        mTagsLabel.setText(android.text.TextUtils.join(", ", mBadge.getTags()));
        mAddressLabel.setText(android.text.TextUtils.join(", ", mBadge.getAddress()));
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mAddressLabel) {
            double latitude = mBadge.getLatitude();
            double longitude = mBadge.getLongitude();

            Uri location = Uri.parse("geo:" + latitude + "," + longitude + "?z=14&q=<" + latitude  + ">,<" + longitude + ">(" + mBadge.getName() + ")");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        }
    }
}
