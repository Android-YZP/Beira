package com.company1075.Beira.activitys;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
    private ImageView mIvSpecial1;
    private ImageView mIvSpecial1_0;
    private ImageView mIvSpecial1_1;
    private ImageView mIvSpecial1_2;
    private AnimatorSet set;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initView() {
        mIvStart = findViewById(R.id.iv_start);
        mIvSpecial1 = findViewById(R.id.iv_special1);
        mIvSpecial1_0 = findViewById(R.id.iv_special1_0);
        mIvSpecial1_1 = findViewById(R.id.iv_special1_1);
        mIvSpecial1_2 = findViewById(R.id.iv_special1_2);
    }

    @Override
    protected void initData() {

        startAnimator(mIvSpecial1, 0f, 3600f);
//        startAnimator(mIvSpecial1_0, 0f, -360f);
        startAnimator(mIvSpecial1_1, 0f, -3600f);
//        startAnimator(mIvSpecial1_2, 0f, -360f);

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

    private void startAnimator(View view, float f1, float f2) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", f1, f2);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);

        set = new AnimatorSet();
        set.setDuration(55000);
        set.playTogether(animator);
        set.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        set.cancel();
    }
}
