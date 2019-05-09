package com.company1075.Beira.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.com1075.library.base.BaseActivity;
import com.company1075.Beira.MainActivity;
import com.company1075.Beira.R;
import com.squareup.haha.perflib.Main;

public class ScanActivity extends BaseActivity {

    private ImageView mIvStart;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initView() {
        mIvStart = findViewById(R.id.iv_start);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        mIvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScanActivity.this, DiagnosisDetailsActivity.class));
            }
        });
    }
}
