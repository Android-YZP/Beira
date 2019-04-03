package com.company1075.Beira.presenter;

import com.com1075.library.base.BaseActivity;
import com.com1075.library.base.BasePresenter;
import com.com1075.library.http.exception.ApiException;
import com.com1075.library.http.observer.HttpRxObservable;
import com.com1075.library.http.observer.HttpRxObserver;
import com.com1075.library.http.retrofit.HttpRequest;
import com.com1075.library.utils.StringUtils;
import com.com1075.library.utils.ToastUtils;
import com.company1075.Beira.api.ApiUtils;
import com.company1075.Beira.contract.ITestContract;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class TestPresenter extends BasePresenter<ITestContract, BaseActivity> {
    private final String TAG = TestPresenter.class.getSimpleName();
    private BaseActivity activity;
    public TestPresenter(ITestContract view, BaseActivity activity) {
        super(view, activity);
        this.activity = activity;
    }

    /**
     * 获取信息
     *
     * @author 姚中平
     */
    public void HttpLogin(String phone) {

        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("phone", "17625017026");
        request.put("password", StringUtils.md5("qqqqqq" + "7625017026".substring(0, 5)));

        HttpRxObserver httpRxObserver = new HttpRxObserver(TAG + "getInfo") {

            @Override
            protected void onStart(Disposable d) {
                if (getView() != null)
                    getView().LoadingData();
            }

            @Override
            protected void onError(ApiException e) {
                Logger.e(e.toString() + "");
                if (getView() != null){
                    getView().LoadingDataFail(e.getMsg());
                    ToastUtils.showLongToast(activity,e.getMsg());
                }

            }

            @Override
            protected void onSuccess(Object response) {
                Logger.e(response + "");
                if (getView() != null)
                    getView().LoadingDataSuccess(response.toString());

            }
        };

        HttpRxObservable.getObservable(ApiUtils.getTestApi().login(request), getActivity()).subscribe(httpRxObserver);
    }
}
