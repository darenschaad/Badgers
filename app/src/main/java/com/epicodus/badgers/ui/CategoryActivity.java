package com.epicodus.badgers.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.epicodus.badgers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.cat000TextView) TextView mCat000TextView;
    @BindView(R.id.cat000ImageView) ImageView mCat000ImageView;
    @BindView(R.id.cat100TextView) TextView mCat100TextView;
    @BindView(R.id.cat100ImageView) ImageView mCat100ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        mCat000TextView.setOnClickListener(this);
        mCat000ImageView.setOnClickListener(this);
        mCat100TextView.setOnClickListener(this);
        mCat000ImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.cat000TextView:
                Intent intent = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent.putExtra("category", "000");
                startActivity(intent);
                break;
            case R.id.cat000ImageView:
                Intent intent2 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent2.putExtra("category", "000");
                startActivity(intent2);
                break;
            case R.id.cat100TextView:
                Intent intent3 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent3.putExtra("category", "100");
                startActivity(intent3);
                break;
            case R.id.cat100ImageView:
                Intent intent4 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent4.putExtra("category", "100");
                startActivity(intent4);
                break;
        }
    }
}
