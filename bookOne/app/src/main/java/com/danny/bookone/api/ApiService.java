package com.danny.bookone.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/site/versions")
    Call<VersionBean> getVersion();
}
