package com.epicodus.badgers.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.badgers.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.searchEditText) EditText mSearchEditText;
    @BindView(R.id.searchButton) Button mSearchButton;
    @BindView(R.id.viewAllButton) Button mViewAllButton;
    @BindView(R.id.viewCategoryButton) Button mViewCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mSearchButton = (Button) findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(this);
        mViewAllButton.setOnClickListener(this);
        mViewCategoryButton.setOnClickListener(this);
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
        }
    }
}
