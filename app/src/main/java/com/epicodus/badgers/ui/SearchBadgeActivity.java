package com.epicodus.badgers.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class SearchBadgeActivity extends AppCompatActivity {
    @BindView(R.id.searchRecyclerView) RecyclerView msearchRecyclerView;
    private BadgeListAdapter mAdapter;

    private DatabaseReference mRef;
    private ValueEventListener mRefListener;
    public ArrayList<Badge> mBadges = new ArrayList<>();
    private String keyWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_badge);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        final ArrayList<String> keyWords = intent.getStringArrayListExtra("keywords");
        Log.d("location", keyWords.get(0));
        Log.d("location", keyWords.get(1));


        mRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_BADGES);

        mRefListener = mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot badgeSnapShot : dataSnapshot.getChildren()) {
                    Badge badge = badgeSnapShot.getValue(Badge.class);
                    for (int i=0; i<keyWords.size(); i++ ){
                        for (int j=0; j<badge.getTags().size(); j++) {
                            if (badge.getTags().get(j).contains(keyWords.get(i))) {
                                if(!mBadges.contains(badge)) {
                                    mBadges.add(badge);
                                    break;
                                }
                            }
                        }
                    }
                }
                mAdapter = new BadgeListAdapter(getApplicationContext(), mBadges);
                msearchRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchBadgeActivity.this);
                msearchRecyclerView.setLayoutManager(layoutManager);
                msearchRecyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
