package com.company1075.Beira;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.com1075.library.base.BaseActivity;
import com.company1075.Beira.activitys.GoodsInfoActivity;
import com.company1075.Beira.contract.ITestContract;
import com.company1075.Beira.presenter.TestPresenter;
import com.company1075.Beira.utils.GlideImageLoader;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.beta.Beta;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

//您的密钥库包含 1 个条目
//
//        别名: key0
//        创建日期: 2019-4-3
//        条目类型: PrivateKeyEntry
//        证书链长度: 1
//        证书[1]:
//        所有者: CN=company1075, OU=company1075, O=company1075, L=company1075, ST=company1075, C=1075
//        发布者: CN=company1075, OU=company1075, O=company1075, L=company1075, ST=company1075, C=1075
//        序列号: 65bb06be
//        有效期开始日期: Wed Apr 03 10:47:00 CST 2019, 截止日期: Sun Mar 27 10:47:00 CST 2044
//        证书指纹:
//        MD5: AB:B2:64:EB:78:F1:5D:4C:F3:48:78:5F:03:E6:60:66
//        SHA1: F6:00:E3:99:27:2D:F9:2A:8F:74:35:CC:54:85:F1:04:2F:7E:CD:2C
//        SHA256: FE:91:30:F2:C4:4F:98:3C:FC:DD:CA:B2:BB:66:42:64:4A:A8:57:59:24:18:B6:E1:63:77:B0:BB:7A:4D:7C:56
//        签名算法名称: SHA256withRSA
//        版本: 3
//
//        扩展:
//
//        #1: ObjectId: 2.5.29.14 Criticality=false
//        SubjectKeyIdentifier [
//        KeyIdentifier [
//        0000: BA 73 3E C6 19 C6 64 5B   CF B6 B6 BE 52 15 18 2E  .s>...d[....R...
//        0010: 1D A0 01 ED
public class MainActivity extends BaseActivity implements AMapLocationListener, ITestContract {
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    private TextView mTextView;
    private Banner mBanner;
    List<Integer> images = new ArrayList<>();
    private TestPresenter mTestPresenter = new TestPresenter(this, this);
    private RelativeLayout mRlGoodsInfo;

    @Override
    protected void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv);
        mBanner = findViewById(R.id.banner);

        mRlGoodsInfo = findViewById(R.id.rl_goods_info);
    }

    @Override
    protected void initData() {
        initLocation();
        initBanner();
        Beta.checkUpgrade();

        mTestPresenter.HttpLogin("");
    }


    @Override
    protected void setListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Beta.checkUpgrade(true, false);
            }
        });
        mRlGoodsInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GoodsInfoActivity.class));
            }
        });
    }

    @Override
    public void LoadingData() {

    }

    @Override
    public void LoadingDataFail(String result) {

    }

    @Override
    public void LoadingDataSuccess(String result) {

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //可在其中解析amapLocation获取相应内容。
                Logger.e(aMapLocation.toString());
                mTextView.setText(aMapLocation.getCity());
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }


    private void initBanner() {
        images.add(R.mipmap.ziwaixian);
        images.add(R.mipmap.ziwaixian);
        images.add(R.mipmap.ziwaixian);
        images.add(R.mipmap.ziwaixian);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(1000 * 60);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }


}
