package com.example.floword;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("query")
    Call<Response> getBirthdayFlower(@Query("keyword") String keyword, @Query("key") String key);
}
