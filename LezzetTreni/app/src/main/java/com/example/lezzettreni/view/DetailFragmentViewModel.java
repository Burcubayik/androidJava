package com.example.lezzettreni.view;

import androidx.lifecycle.ViewModel;

import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.repo.FoodsDaoRepository;

public class DetailFragmentViewModel extends ViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    public void add(String foodName, String pictureName, int foodPrice, int orderAmount ){
        frepo.addFood(foodName,pictureName,foodPrice,orderAmount,"burcu_bayik");

    }

}
