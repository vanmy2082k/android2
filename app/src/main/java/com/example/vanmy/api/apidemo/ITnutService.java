package com.example.vanmy.api.apidemo;

import okhttp3.ResponseBody;
import com.example.vanmy.utils.Constants;
import com.example.vanmy.api.requesthelper.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITnutService {

    ITnutService SERVICE = RetrofitClient.getInstance().getService(Constants.BASE_URL_TNUT, ITnutService.class);

    @GET("/api.aspx")
    Call<ResponseBody> getInfo(@Query("action") String action);
    //http://tms.tnut.edu.vn:9630/54kmt/?masv={masv}
    ITnutService SERVICE1 = RetrofitClient.getInstance().getService("http://tms.tnut.edu.vn:9630/", ITnutService.class);

    @GET("/54kmt/")
    Call<ResponseBody> getInfoMSSV(@Query("masv") String masv);
}
