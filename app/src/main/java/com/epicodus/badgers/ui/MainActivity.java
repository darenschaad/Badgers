package com.epicodus.badgers.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.badgers.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.searchEditText) EditText mSearchEditText;
    @BindView(R.id.searchButton) Button mSearchButton;
    @BindView(R.id.viewAllButton) Button mViewAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mSearchButton = (Button) findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(this);
        mViewAllButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchButton:
                String[] keywordArray =(mSearchEditText.getText().toString().split(", | "));
                ArrayList<String> keywords = new ArrayList<>(Arrays.asList(keywordArray));
                Intent intent = new Intent(MainActivity.this, SearchBadgeActivity.class);
                intent.putStringArrayListExtra("keywords",keywords);
                startActivity(intent);
                break;
            case R.id.viewAllButton:
                Intent intent1 = new Intent(MainActivity.this, AllBadgeActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
