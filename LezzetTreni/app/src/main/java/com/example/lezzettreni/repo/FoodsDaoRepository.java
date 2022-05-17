package com.example.lezzettreni.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.lezzettreni.entity.CartFoodAnswer;
import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.entity.FoodsAnswer;
import com.example.lezzettreni.retrofit.ApiUtils;
import com.example.lezzettreni.retrofit.CartFoodDaoInterface;
import com.example.lezzettreni.retrofit.FoodsDaoInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsDaoRepository {
    private MutableLiveData<List<Foods>> foodList;
    private FoodsDaoInterface fdao;
    private CartFoodDaoInterface cfdao;

    public FoodsDaoRepository() {
        fdao = ApiUtils.getFoodsDaoInterface();
        foodList = new MutableLiveData<>();

    }
    public MutableLiveData<List<Foods>> getFoods(){
        return foodList;
    }

    public void getAllFoods(){
       fdao.Allfoods().enqueue(new Callback<FoodsAnswer>() {
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

    public void addToCart(String foodName, String pictureName, int foodPrice, int orderAmount, String userName){

        cfdao.addToCart(foodName,pictureName,foodPrice,orderAmount,userName).enqueue(new Callback<CartFoodAnswer>() {
            @Override
            public void onResponse(Call<CartFoodAnswer> call, Response<CartFoodAnswer> response) {

            }

            @Override
            public void onFailure(Call<CartFoodAnswer> call, Throwable t) {

            }
        });



    }


}
