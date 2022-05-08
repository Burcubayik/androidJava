package com.example.todoapp.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapp.R;
import com.example.todoapp.databinding.FragmentKayitBinding;
import com.example.todoapp.viewmodel.KayitFragmentViewModel;
import com.example.todoapp.viewmodel.KayitVMF;

public class KayitFragment extends Fragment {
    private FragmentKayitBinding tasarim;
    private KayitFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false);
        tasarim.setKayitFragment(this);
        tasarim.setKayitToolbarBaslik("Yapılacak İş Kayıt");

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this,new KayitVMF(requireActivity().getApplication())).get(KayitFragmentViewModel.class);
    }

    public void buttonKaydetTikla(String yapilacak_is){
        viewModel.kayit(yapilacak_is);

    }
}