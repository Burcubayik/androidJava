package com.example.lezzettreni.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.entity.CartFoodAnswer;
import com.example.lezzettreni.repo.FoodsDaoRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartFragmentViewModel extends ViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    public MutableLiveData<List<CartFood>> cartFoodList = new MutableLiveData<>();

    public CartFragmentViewModel(){
        getFoods();
    }


    public void getFoods(){
        frepo.fdao.getCartFoods("burcu_bayik").enqueue(new Callback<CartFoodAnswer>() {
            @Override
            public void onResponse(Call<CartFoodAnswer> call, Response<CartFoodAnswer> response) {
                cartFoodList.setValue(response.body().getCartFoods());
            }

            @Override
            public void onFailure(Call<CartFoodAnswer> call, Throwable t) {

            }
        });
    }


}
