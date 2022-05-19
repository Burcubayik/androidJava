package com.example.lezzettreni.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.adapter.CartAdapter;
import com.example.lezzettreni.databinding.FragmentCartBinding;
import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.view.CartFragmentViewModel;

public class CartFragment extends Fragment {
    private FragmentCartBinding design;
    private CartFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false);
        design.setTooblarCartTitle("Sepet");


        viewModel.cartFoodList.observe(getViewLifecycleOwner(),list->{
            CartAdapter cartAdapter = new CartAdapter(requireContext(),list,viewModel);
            design.setCartAdapter(cartAdapter);
        });

        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CartFragmentViewModel.class);
    }
}