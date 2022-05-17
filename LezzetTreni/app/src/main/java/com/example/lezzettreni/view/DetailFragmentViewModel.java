package com.example.lezzettreni.view;

import com.example.lezzettreni.repo.FoodsDaoRepository;

public class DetailFragmentViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    public void add(String foodName, String pictureName, int foodPrice, int orderAmount ){
        frepo.addToCart(foodName,pictureName,foodPrice,orderAmount,"burcu_bayik");
    }

}
