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
import android.widget.LinearLayout;
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
    @BindView(R.id.click0Layout) LinearLayout mClick0Layout;
    @BindView(R.id.click1Layout) LinearLayout mClick1Layout;
    @BindView(R.id.click2Layout) LinearLayout mClick2Layout;
    @BindView(R.id.click3Layout) LinearLayout mClick3Layout;
    @BindView(R.id.click4Layout) LinearLayout mClick4Layout;
    @BindView(R.id.click5Layout) LinearLayout mClick5Layout;
    @BindView(R.id.click6Layout) LinearLayout mClick6Layout;
    @BindView(R.id.click7Layout) LinearLayout mClick7Layout;
    @BindView(R.id.click8Layout) LinearLayout mClick8Layout;
    @BindView(R.id.click9Layout) LinearLayout mClick9Layout;

    double height;
    double width;
    double screenHeight;
    double screenWidth;

    LinearLayout[] clickLayouts;
    String[] categoryNumbers = {"000", "100", "200", "300", "400", "500", "600", "700", "800", "900"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        TextView[] textViews = {mCat000TextView, mCat100TextView, mCat200TextView, mCat300TextView, mCat400TextView, mCat500TextView, mCat600TextView, mCat700TextView, mCat800TextView, mCat900TextView};
        ImageView[] imageViews = {mCat000ImageView, mCat100ImageView, mCat200ImageView, mCat300ImageView, mCat400ImageView, mCat500ImageView, mCat600ImageView, mCat700ImageView, mCat800ImageView, mCat900ImageView};
        LinearLayout[] clickLayouts = {mClick0Layout, mClick1Layout, mClick2Layout, mClick3Layout, mClick4Layout, mClick5Layout, mClick6Layout, mClick7Layout, mClick8Layout, mClick9Layout};

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

        Typeface bebas = Typeface.createFromAsset(this.getAssets(),"fonts/bebas.otf");

        for (int i = 0 ; i < textViews.length ; i++){
            textViews[i].setTypeface(bebas);
            textViews[i].setTextSize( (float) screenHeight * 5);
        }

        for (int i = 0 ; i < imageViews.length ; i++) {
            Picasso.with(this).load("https://spcilk.github.io/badger-badge-images/images/" + categoryNumbers[i] + ".png").resize(400,400).into(imageViews[i]);
        }

        for (int i = 0 ; i < clickLayouts.length ; i++) {
            clickLayouts[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0 ; i < clickLayouts.length ; i++)
        if (v == clickLayouts[i]) {
            Intent intent = new Intent(CategoryActivity.this, AllBadgeActivity.class);
            intent.putExtra("category", categoryNumbers[i]);
            startActivity(intent);
        }
    }
}
