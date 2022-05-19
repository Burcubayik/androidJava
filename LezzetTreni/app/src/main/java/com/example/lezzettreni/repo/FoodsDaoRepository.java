package com.example.lezzettreni.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.entity.CartFoodAnswer;
import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.entity.FoodsAnswer;
import com.example.lezzettreni.retrofit.ApiUtils;
import com.example.lezzettreni.retrofit.FoodsDaoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsDaoRepository {
    private MutableLiveData<List<Foods>> foodList;
    private MutableLiveData<List<CartFood>> cFoodList;
    public FoodsDaoInterface fdao;


    public FoodsDaoRepository() {
        fdao = ApiUtils.getFoodsDaoInterface();
        foodList = new MutableLiveData<>();

    }
    public MutableLiveData<List<Foods>> getFoods(){
        return foodList;
    }
    public MutableLiveData<List<CartFood>> getCFoods(){
        return cFoodList;
    }

    public void getAllFoods(){
       fdao.allFoods().enqueue(new Callback<FoodsAnswer>() {
           @Override
           public void onResponse(Call<FoodsAnswer> call, Response<FoodsAnswer> response) {
               List<Foods> list = response.body().getFoods();
               foodList.setValue(list);
           }

           @Override
           public void onFailure(Call<FoodsAnswer> call, Throwable t) {

           }
       });
    }

    public void addFood(String foodName, String pictureName, int foodPrice, int orderAmount, String userName){


        fdao.addToCart(foodName,pictureName,foodPrice,orderAmount,userName).enqueue(new Callback<CartFoodAnswer>() {
            @Override
            public void onResponse(Call<CartFoodAnswer> call, Response<CartFoodAnswer> response) {

            }

            @Override
            public void onFailure(Call<CartFoodAnswer> call, Throwable t) {


            }
        });

    }




}
