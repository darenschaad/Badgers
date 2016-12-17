package com.epicodus.badgers.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.epicodus.badgers.Constants;
import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.searchEditText) EditText mSearchEditText;
    @BindView(R.id.searchButton) Button mSearchButton;
    @BindView(R.id.viewAllButton) Button mViewAllButton;
    @BindView(R.id.viewCategoryButton) Button mViewCategoryButton;
    @BindView(R.id.randomButton) Button mRandomButton;
    @BindView(R.id.nameImageView) ImageView mNameImageView;
    @BindView(R.id.logoImageView) ImageView mLogoImageView;

    private ArrayList<Badge> mBadges = new ArrayList<>();
    private DatabaseReference mRef;
    private ValueEventListener mRefListener;
    public int mBadgeCount;
    public int mRandomNumber;
    double height;
    double width;
    double screenHeight;
    double screenWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
        mViewAllButton.setOnClickListener(this);
        mViewCategoryButton.setOnClickListener(this);
        mRandomButton.setOnClickListener(this);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int density = metrics.densityDpi;
        screenWidth = width/(double)density;
        screenHeight = height/(double)density;
        double x = Math.pow(screenWidth,2);
        double y = Math.pow(screenHeight,2);
        double screenInches = Math.sqrt(x+y);

//        mNameImageView.getLayoutParams().width = (int) screenWidth/4;

        Log.d("Array", mBadges.size() + "");
        mBadges.clear();
        mRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_BADGES);
        mRefListener = mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot badgeSnapShot : dataSnapshot.getChildren()) {
                    Badge badge = badgeSnapShot.getValue(Badge.class);
                    mBadges.add(badge);
                }
                mBadgeCount = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchButton:
                String searchQuery = mSearchEditText.getText().toString();
                Log.d("editText", mSearchEditText.getText().toString());
                if(searchQuery.trim().equals("")){
                    Toast.makeText(this,"Please Provide a Keyword, or Keywords to Search Badges", Toast.LENGTH_LONG).show();
                }
                else {
                    String[] keywordArray =(searchQuery.split(", | |,"));
                    ArrayList<String> keywords = new ArrayList<>(Arrays.asList(keywordArray));
                    Intent intent = new Intent(MainActivity.this, SearchBadgeActivity.class);
                    intent.putStringArrayListExtra("keywords",keywords);
                    startActivity(intent);
                }

                break;
            case R.id.viewAllButton:
                Intent intent1 = new Intent(MainActivity.this, AllBadgeActivity.class);
                startActivity(intent1);
                break;
            case R.id.viewCategoryButton:
                Intent intent2 = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent2);
                break;
            case R.id.randomButton:
                Log.d("ArrayButton", mBadges.size() + "");
                Random random = new Random();
                mRandomNumber = random.nextInt(mBadgeCount);
                Log.d("ArrayNumber", mRandomNumber + "hello");
                int itemPosition = mRandomNumber;
                Intent intent3 = new Intent(MainActivity.this, BadgeDetailActivity.class);
                intent3.putExtra("position", itemPosition);
                intent3.putExtra("badges", Parcels.wrap(mBadges));
                startActivity(intent3);
                break;
        }
    }
}
