package com.example.floword;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://apis.juhe.cn/fapig/birthdayFlower/";
    private static Retrofit retrofit = null;
    private static RetrofitClient mInstance;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public ApiService getApiService(){
        return retrofit.create(ApiService.class);
    }
}
