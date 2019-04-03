package com.company1075.Beira.api;



import com.com1075.library.http.retrofit.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author 姚中平
 */
public interface PhoneApi {

    @GET("v1/mobile/address/query")
    Observable<HttpResponse> phoneQuery(@QueryMap Map<String, Object> request);

}
