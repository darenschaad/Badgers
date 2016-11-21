package com.epicodus.badgers.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.epicodus.badgers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.cat000Layout) RelativeLayout mCat000Layout;
    @BindView(R.id.cat100Layout) RelativeLayout mCat100Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        mCat000Layout.setOnClickListener(this);
        mCat100Layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.cat000Layout:
                Intent intent = new Intent(CategoryActivity.this, AllBadgeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
