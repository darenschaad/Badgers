package com.epicodus.badgers.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.epicodus.badgers.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.cat000TextView) TextView mCat000TextView;
    @BindView(R.id.cat000ImageView) ImageView mCat000ImageView;
    @BindView(R.id.cat100TextView) TextView mCat100TextView;
    @BindView(R.id.cat100ImageView) ImageView mCat100ImageView;
    @BindView(R.id.cat200TextView) TextView mCat200TextView;
    @BindView(R.id.cat200ImageView) ImageView mCat200ImageView;
    @BindView(R.id.cat300TextView) TextView mCat300TextView;
    @BindView(R.id.cat300ImageView) ImageView mCat300ImageView;


    double height;
    double width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        mCat000TextView.setOnClickListener(this);
        mCat000ImageView.setOnClickListener(this);
        mCat100TextView.setOnClickListener(this);
        mCat100ImageView.setOnClickListener(this);
        mCat200TextView.setOnClickListener(this);
        mCat200ImageView.setOnClickListener(this);
        mCat300TextView.setOnClickListener(this);
        mCat300ImageView.setOnClickListener(this);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;
        Log.d("Screen Size", Double.toString(width));

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int density = metrics.densityDpi;
        Log.d("density", density + "");
        double screenWidth = (double)width/(double)density;
        double screenHeight = (double)height/(double)density;
        double x = Math.pow(screenWidth,2);
        double y = Math.pow(screenHeight,2);
        double screenInches = Math.sqrt(x+y);
        Log.d("Screen width", Double.toString(screenInches));

        mCat000ImageView.getLayoutParams().height = (int) height/8;
        mCat100ImageView.getLayoutParams().height = (int) height/8;
        mCat200ImageView.getLayoutParams().height = (int) height/8;
        mCat300ImageView.getLayoutParams().height = (int) height/8;

        mCat000TextView.setTextSize( (float) height/55);
        mCat100TextView.setTextSize( (float) height/55);
        mCat200TextView.setTextSize( (float) height/55);
        mCat300TextView.setTextSize( (float) height/55);

        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/000.png").into(mCat000ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/100.png").into(mCat100ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/200.png").into(mCat200ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/300.png").into(mCat300ImageView);




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
            case R.id.cat200TextView:
                Intent intent5 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent5.putExtra("category", "200");
                startActivity(intent5);
                break;
            case R.id.cat200ImageView:
                Intent intent6 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent6.putExtra("category", "200");
                startActivity(intent6);
                break;
            case R.id.cat300TextView:
                Intent intent7 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent7.putExtra("category", "300");
                startActivity(intent7);
                break;
            case R.id.cat300ImageView:
                Intent intent8 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent8.putExtra("category", "300");
                startActivity(intent8);
                break;
        }
    }
}
