package com.example.lezzettreni.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.FragmentCartBinding;

public class CartFragment extends Fragment {
    private FragmentCartBinding design;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false);
        return design.getRoot();
    }
}