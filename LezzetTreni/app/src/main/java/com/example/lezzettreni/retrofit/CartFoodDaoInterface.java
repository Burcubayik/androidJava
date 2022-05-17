package com.example.lezzettreni.retrofit;

import com.example.lezzettreni.entity.CartFoodAnswer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CartFoodDaoInterface {

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CartFoodAnswer> addToCart(@Field("yemek_adi") String foodName, @Field("yemek_resim_adi") String pictureName, @Field("yemek_fiyat") int foodPrice, @Field("yemek_siparis_adet") int orderAmount, @Field("kullanici_adi") String userName);




}
