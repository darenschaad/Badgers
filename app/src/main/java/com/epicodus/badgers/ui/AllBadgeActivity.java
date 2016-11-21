package com.epicodus.badgers.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.epicodus.badgers.Constants;
import com.epicodus.badgers.R;
import com.epicodus.badgers.adapters.BadgeListAdapter;
import com.epicodus.badgers.models.Badge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllBadgeActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.filterSpinner) Spinner mFilterSpinner;
    private BadgeListAdapter mAdapter;


    private DatabaseReference mRef;
    private ValueEventListener mRefListener;
    public ArrayList<Badge> mBadges = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_badge);
        ButterKnife.bind(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.filterArray, R.layout.spinner_item);
        mFilterSpinner.setAdapter(adapter);

        mRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_BADGES);

        mRefListener = mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot badgeSnapShot : dataSnapshot.getChildren()) {
                    Badge badge = badgeSnapShot.getValue(Badge.class);
                    mBadges.add(badge);
                }
                mAdapter = new BadgeListAdapter(getApplicationContext(), mBadges);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AllBadgeActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener(mRefListener);
    }
}
