package com.epicodus.badgers.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.badgers.Constants;
import com.epicodus.badgers.R;
import com.epicodus.badgers.models.Badge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AllBadgeActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private ValueEventListener mRefListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_badge);

        mRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_BADGES);

        mRefListener = mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot badgeSnapShot : dataSnapshot.getChildren()) {
                    Badge badge = badgeSnapShot.getValue(Badge.class);
                    Log.d("FireBase Test", badge.getImageUrl());
                }
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
