package com.example.lezzettreni.retrofit;

import com.example.lezzettreni.entity.CartFoodAnswer;
import com.example.lezzettreni.entity.FoodsAnswer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodsDaoInterface {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    Call<FoodsAnswer> Allfoods();


}
