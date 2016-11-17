package com.epicodus.badgers.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.TableRow;
import android.widget.TextView;

import com.epicodus.badgers.Constants;
import com.epicodus.badgers.R;
import com.epicodus.badgers.adapters.BadgeListAdapter;
import com.epicodus.badgers.models.Badge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
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
    @BindView(R.id.myBadgeTextView) TextView mMyBadgeTextView;
    @BindView(R.id.activityTextView) TextView mActivityTextView;
    @BindView(R.id.deweyClassTextView) TextView mDewyClassTextView;
    @BindView(R.id.toDoTextView) TextView mToDoTextView;
    @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.proofWordTextView) TextView mProofWordTextView;
    @BindView(R.id.proofTextView) TextView mProofTextView;
    @BindView(R.id.creatorWordTextView) TextView mCreatorWordTextView;
    @BindView(R.id.creatorTextView) TextView mCreatorTextView;
    @BindView(R.id.dateWordTextView) TextView mDateWordTextView;
    @BindView(R.id.dateTextView) TextView mDateTextView;
    @BindView(R.id.badgeQualification) TextView mBadgeQualification;


//    @BindView(R.id.saveBadgeButton) Button mSaveBadgeButton;
    @BindView(R.id.imageLayout) LinearLayout mImageLayout;
//    @BindView(R.id.descriptionLayout) LinearLayout mDescriptionLayout;
    @BindView(R.id.backgroundLayout) LinearLayout mBackgroundLayout;
    @BindView(R.id.backgroundLayout2) LinearLayout mBackgroundLayout2;
    @BindView(R.id.divider1) View mView1;
    @BindView(R.id.divider2) View mView2;
    @BindView(R.id.divider3) View mView3;
    @BindView(R.id.divider4) View mView4;
    @BindView(R.id.divider5) View mView5;
    @BindView(R.id.divider6) View mView6;
    @BindView(R.id.divider7) View mView7;
    @BindView(R.id.divider8) View mView8;
    @BindView(R.id.divider9) View mView9;
    @BindView(R.id.divider10) View mView10;
    @BindView(R.id.divider11) View mView11;
    @BindView(R.id.divider12) View mView12;
    @BindView(R.id.divider13) View mView13;
    @BindView(R.id.qualificationTableRow) TableRow mQualificationTableRow;

    private Badge mBadge;
    private String mImageUrl;
    private DatabaseReference mRef;
    private ValueEventListener mRefListener;
    public String mImgage;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    private static Context mContext;
    double height;
    double width;

    Integer[] categories = {0,100,200,300,400,500,600,700,800,900};
    int[] categoryTextColors = {R.color.category0Text, R.color.category100Text,R.color.category200Text, R.color.category300Text, R.color.category400Text, R.color.category500Text, R.color.category600Text, R.color.category700Text, R.color.category800Text, R.color.category900Text};
    int[] categoryColors = {R.color.category0Primary, R.color.category100Primary, R.color.category200Primary, R.color.category300Primary, R.color.category400Primary, R.color.category500Primary, R.color.category600Primary, R.color.category700Primary, R.color.category800Primary, R.color.category900Primary};
    String[] categoryText = {"000 - GENERAL KNOWLEDGE", "100 - PHILOSOPHY & PSYCHOLOGY", "200 - RELIGION", "300 - SOCIAL SCIENCE", "400 - LANGUAGES", "500 - SCIENCE", "600 - TECHNOLOGY", "700 - ARTS & RECREATION", "800 - LITERATURE", "900 - HISTORY & GEOGRAPHY"};

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
        mRef  = FirebaseDatabase.getInstance().getReference().child("images").child(Integer.toString(mBadge.getPushId()));
        mRefListener = mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot imageSnapShot : dataSnapshot.getChildren()) {
                    String image = imageSnapShot.getValue(String.class);
                    mBadge.setImageUrl(image);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_badge_detail, container, false);
        ButterKnife.bind(this, view);
//        mAddressLabel.setOnClickListener(this);
        Picasso.with(mContext).load(mBadge.getImageUrl()).resize((int) width/4,(int) width/4).centerCrop().into(mImageLabel);




        mNameLabel.setText(mBadge.getName());
        mIndexLabel.setText(mBadge.getIndex().substring(1));
        mCreatorTextView.setText(mBadge.getCreator() + "\n");
        mDateTextView.setText(mBadge.getDate() + "\n");
        ViewGroup.LayoutParams params = mCategoryLabel.getLayoutParams();
        params.width = (int) height;
        mCategoryLabel.setLayoutParams(params);
        if (mBadge.getComments().equals("")) {
            mDescriptionTextView.setText(mBadge.getDescription() + "\n");
        } else {
            String concat = (mBadge.getDescription() + "\n\n" + mBadge.getComments() + "\n");
            mDescriptionTextView.setText(concat);
        }

        mProofTextView.setText(mBadge.getProof() + "\n");


        ViewGroup.LayoutParams params1 = mImageLayout.getLayoutParams();
        params1.height = (int) (height/3.4);
        mImageLayout.setLayoutParams(params1);

        ViewGroup.LayoutParams params2 = mImageLabel.getLayoutParams();
        params2.height = (int) width/3;
        params2.width = (int) width/3;
        mImageLabel.setLayoutParams(params2);

        setColorsAndCategoryText();

        Typeface futura = Typeface.createFromAsset(getActivity().getAssets(),"fonts/futura-condensed-normal.ttf");
        Typeface bebas = Typeface.createFromAsset(getActivity().getAssets(),"fonts/bebas.otf");
        mCategoryLabel.setTypeface(bebas);
        mMyBadgeTextView.setTypeface(bebas);
        mToDoTextView.setTypeface(futura);
        mDescriptionTextView.setTypeface(futura);
        mProofWordTextView.setTypeface(futura);
        mProofTextView.setTypeface(futura);
        mCreatorWordTextView.setTypeface(futura);
        mCreatorTextView.setTypeface(futura);
        mDateWordTextView.setTypeface(futura);
        mDateTextView.setTypeface(futura);
        mBadgeQualification.setTypeface(bebas);
        mDewyClassTextView.setTypeface(bebas);
        mIndexLabel.setTypeface(bebas);
        mActivityTextView.setTypeface(bebas);
        mNameLabel.setTypeface(bebas);
//        mTagsLabel.setText(android.text.TextUtils.join(", ", mBadge.getTags()));
        return view;
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

    private void setColorsAndCategoryText() {
        int category = mBadge.getCategory();
        int categoryIndex = Arrays.asList(categories).indexOf(category);
        int categoryTextColor = categoryTextColors[categoryIndex];
        int categoryColor = categoryColors[categoryIndex];
        mCategoryLabel.setText(categoryText[categoryIndex]);
        setMaincolor(categoryColor);
        setViewDividerColor(categoryTextColor);
        setTextViewColor(categoryTextColor);
        if (category == 700){
            mCategoryLabel.setTextColor(ContextCompat.getColor(mContext, R.color.category700TextSeondary));
            mMyBadgeTextView.setTextColor(ContextCompat.getColor(mContext, R.color.category700TextSeondary));
        }
    }

    private void setMaincolor(int categoryColor) {
        View[] backgroundViews = {mBackgroundLayout, mBackgroundLayout2};
        for (int i=0 ; i<backgroundViews.length ; i++){
            backgroundViews[i].setBackgroundColor(ContextCompat.getColor(mContext, categoryColor));
        }
    }

    private void setTextViewColor(int categoryTextColor) {
        TextView[] textViews = {mNameLabel, mIndexLabel, mActivityTextView, mDewyClassTextView, mToDoTextView, mDescriptionTextView, mProofWordTextView, mProofTextView, mCategoryLabel, mMyBadgeTextView, mCreatorWordTextView, mCreatorTextView, mDateWordTextView, mDateTextView};
        for (int i=0 ; i<textViews.length ; i++){
            textViews[i].setTextColor(ContextCompat.getColor(mContext, categoryTextColor));
        }
    }

    private void setViewDividerColor(int categoryTextColor) {
        View[] dividerViews = {mView1, mView2, mView3, mView4, mView5, mView6, mView7, mView8, mView9, mView10, mView11, mView12, mView13, mQualificationTableRow};
        for (int i=0 ; i<dividerViews.length ; i++){
            dividerViews[i].setBackgroundColor(ContextCompat.getColor(mContext, categoryTextColor));
        }
    }
}
