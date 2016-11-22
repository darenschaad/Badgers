package com.epicodus.badgers.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.filterArray, R.layout.spinner_item);
        mFilterSpinner.setAdapter(adapter);
        if (category != null){
            switch (category) {
                case "000":
                    mFilterSpinner.setSelection(1);
                    break;
                case "100":
                    mFilterSpinner.setSelection(2);
                    break;
                case "200":
                    mFilterSpinner.setSelection(3);
                    break;
                case "300":
                    mFilterSpinner.setSelection(4);
                    break;
                case "400":
                    mFilterSpinner.setSelection(5);
                    break;
                case "500":
                    mFilterSpinner.setSelection(6);
                    break;
                case "600":
                    mFilterSpinner.setSelection(7);
                    break;
                case "700":
                    mFilterSpinner.setSelection(8);
                    break;
                case "800":
                    mFilterSpinner.setSelection(9);
                    break;
                case "900":
                    mFilterSpinner.setSelection(10);
                    break;
                default:
                    mFilterSpinner.setSelection(0);
                    break;
            }

        }

        mFilterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mBadges.clear();
                final String filterString = Integer.toString(mFilterSpinner.getSelectedItemPosition());
                mRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_BADGES);
                mRefListener = mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot badgeSnapShot : dataSnapshot.getChildren()) {
                            Badge badge = badgeSnapShot.getValue(Badge.class);
                            Log.d("Filter", filterString);
                            switch (filterString){
                                case "0":
                                    mBadges.add(badge);
                                    break;
                                case "1":
                                    if(badge.getCategory() == 0) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "2":
                                    if(badge.getCategory() == 100) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "3":
                                    if(badge.getCategory() == 200) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "4":
                                    if(badge.getCategory() == 300) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "5":
                                    if(badge.getCategory() == 400) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "6":
                                    if(badge.getCategory() == 500) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "7":
                                    if(badge.getCategory() == 600) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "8":
                                    if(badge.getCategory() == 700) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "9":
                                    if(badge.getCategory() == 800) {
                                        mBadges.add(badge);
                                    }
                                    break;
                                case "10":
                                    if(badge.getCategory() == 900) {
                                        mBadges.add(badge);
                                    }
                                    break;
                            }

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
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener(mRefListener);
    }
}
