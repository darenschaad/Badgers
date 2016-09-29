package com.epicodus.badgers.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.badgers.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllBadgeActivity extends AppCompatActivity {

    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_badge);
    }
}
