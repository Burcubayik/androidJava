package com.example.lezzettreni.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.FragmentDetailBinding;
import com.example.lezzettreni.entity.Foods;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding design;
    private int amount = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        design.setDetailFragment(this);
        design.setDetailToolbarTitle("");
        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        Foods gelenFood = bundle.getFood();

        design.setFoodObject(gelenFood);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenFood.getPictureName();
        Picasso.get().load(url).into(design.imageViewDetail);




        return design.getRoot();
    }

    public void buttonPlusClick(){
        amount++;
        design.textViewDetailAmount.setText(String.valueOf(amount));


    }

}