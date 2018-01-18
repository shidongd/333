package com.example.kaiyuanzhongguo.data.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 石栋 on 2018/1/5.
 */

public interface ApiServer {
    @GET("")
    Call<ResponseBody> getitme(@Query("page") String page);
}
