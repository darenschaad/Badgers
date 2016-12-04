package com.epicodus.badgers.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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
    @BindView(R.id.cat400TextView) TextView mCat400TextView;
    @BindView(R.id.cat400ImageView) ImageView mCat400ImageView;
    @BindView(R.id.cat500TextView) TextView mCat500TextView;
    @BindView(R.id.cat500ImageView) ImageView mCat500ImageView;
    @BindView(R.id.cat600TextView) TextView mCat600TextView;
    @BindView(R.id.cat600ImageView) ImageView mCat600ImageView;
    @BindView(R.id.cat700TextView) TextView mCat700TextView;
    @BindView(R.id.cat700ImageView) ImageView mCat700ImageView;
    @BindView(R.id.cat800TextView) TextView mCat800TextView;
    @BindView(R.id.cat800ImageView) ImageView mCat800ImageView;
    @BindView(R.id.cat900TextView) TextView mCat900TextView;
    @BindView(R.id.cat900ImageView) ImageView mCat900ImageView;

    double height;
    double width;
    double screenHeight;
    double screenWidth;

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
        mCat400TextView.setOnClickListener(this);
        mCat400ImageView.setOnClickListener(this);
        mCat500TextView.setOnClickListener(this);
        mCat500ImageView.setOnClickListener(this);
        mCat600TextView.setOnClickListener(this);
        mCat600ImageView.setOnClickListener(this);
        mCat700TextView.setOnClickListener(this);
        mCat700ImageView.setOnClickListener(this);
        mCat800TextView.setOnClickListener(this);
        mCat800ImageView.setOnClickListener(this);
        mCat900TextView.setOnClickListener(this);
        mCat900ImageView.setOnClickListener(this);

        Typeface bebas = Typeface.createFromAsset(this.getAssets(),"fonts/bebas.otf");

        mCat000TextView.setTypeface(bebas);
        mCat100TextView.setTypeface(bebas);
        mCat200TextView.setTypeface(bebas);
        mCat300TextView.setTypeface(bebas);
        mCat400TextView.setTypeface(bebas);
        mCat500TextView.setTypeface(bebas);
        mCat600TextView.setTypeface(bebas);
        mCat700TextView.setTypeface(bebas);
        mCat800TextView.setTypeface(bebas);
        mCat900TextView.setTypeface(bebas);

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
        screenWidth = (double)width/(double)density;
        screenHeight = (double)height/(double)density;
        double x = Math.pow(screenWidth,2);
        double y = Math.pow(screenHeight,2);
        double screenInches = Math.sqrt(x+y);
        Log.d("Screen width", Double.toString(screenInches));

//        mCat000ImageView.getLayoutParams().height = (int) height/8;
//        mCat100ImageView.getLayoutParams().height = (int) height/8;
//        mCat200ImageView.getLayoutParams().height = (int) height/8;
//        mCat300ImageView.getLayoutParams().height = (int) height/8;
//        mCat400ImageView.getLayoutParams().height = (int) height/8;
//        mCat500ImageView.getLayoutParams().height = (int) height/8;
//        mCat600ImageView.getLayoutParams().height = (int) height/8;
//        mCat700ImageView.getLayoutParams().height = (int) height/8;
//        mCat800ImageView.getLayoutParams().height = (int) height/8;
//        mCat900ImageView.getLayoutParams().height = (int) height/8;

        mCat000TextView.setTextSize( (float) screenHeight * 5);
        mCat100TextView.setTextSize( (float) screenHeight * 5);
        mCat200TextView.setTextSize( (float) screenHeight * 5);
        mCat300TextView.setTextSize( (float) screenHeight * 5);
        mCat400TextView.setTextSize( (float) screenHeight * 5);
        mCat500TextView.setTextSize( (float) screenHeight * 5);
        mCat600TextView.setTextSize( (float) screenHeight * 5);
        mCat700TextView.setTextSize( (float) screenHeight * 5);
        mCat800TextView.setTextSize( (float) screenHeight * 5);
        mCat900TextView.setTextSize( (float) screenHeight * 5);

        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/000.png").into(mCat000ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/100.png").into(mCat100ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/200.png").into(mCat200ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/300.png").into(mCat300ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/400.png").into(mCat400ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/500.png").into(mCat500ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/600.png").into(mCat600ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/700.png").into(mCat700ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/800.png").into(mCat800ImageView);
        Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/900.png").into(mCat900ImageView);
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
            case R.id.cat400TextView:
                Intent intent9 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent9.putExtra("category", "400");
                startActivity(intent9);
                break;
            case R.id.cat400ImageView:
                Intent intent10 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent10.putExtra("category", "400");
                startActivity(intent10);
                break;
            case R.id.cat500TextView:
                Intent intent11 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent11.putExtra("category", "500");
                startActivity(intent11);
                break;
            case R.id.cat500ImageView:
                Intent intent12 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent12.putExtra("category", "500");
                startActivity(intent12);
                break;
            case R.id.cat600TextView:
                Intent intent13 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent13.putExtra("category", "600");
                startActivity(intent13);
                break;
            case R.id.cat600ImageView:
                Intent intent14 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent14.putExtra("category", "600");
                startActivity(intent14);
                break;
            case R.id.cat700TextView:
                Intent intent15 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent15.putExtra("category", "600");
                startActivity(intent15);
                break;
            case R.id.cat700ImageView:
                Intent intent16 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent16.putExtra("category", "700");
                startActivity(intent16);
                break;
            case R.id.cat800TextView:
                Intent intent17 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent17.putExtra("category", "800");
                startActivity(intent17);
                break;
            case R.id.cat800ImageView:
                Intent intent18 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent18.putExtra("category", "800");
                startActivity(intent18);
                break;
            case R.id.cat900TextView:
                Intent intent19 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent19.putExtra("category", "900");
                startActivity(intent19);
                break;
            case R.id.cat900ImageView:
                Intent intent20 = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                intent20.putExtra("category", "900");
                startActivity(intent20);
                break;
        }
    }
}
