package com.billiontags.ecom.inter;

import com.billiontags.ecom.model.GetItems;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by VPS on 02-02-2018.
 */

public interface ApiInterface {

    @GET("json/ecomm.json")
    Call<GetItems> GetPickzy();

    @GET("json/lifestyle.json")
    Call<GetItems> GetLifeStyle();
}
