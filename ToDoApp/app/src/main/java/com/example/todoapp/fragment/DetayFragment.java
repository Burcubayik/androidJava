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
import com.example.todoapp.databinding.FragmentDetayBinding;
import com.example.todoapp.entity.YapilacakIsler;
import com.example.todoapp.viewmodel.DetayFragmentViewModel;
import com.example.todoapp.viewmodel.DetayVMF;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding tasarim;
    private DetayFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false);
        tasarim.setDetayFragment(this);
        tasarim.setDetayToolbarBaslik("Yapılacak İş Detay");
        DetayFragmentArgs bunde = DetayFragmentArgs.fromBundle(getArguments());
        YapilacakIsler gelenYapilacakIs = bunde.getYapilacak();
        tasarim.setYapilacakIsNesnesi(gelenYapilacakIs);

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, new DetayVMF(requireActivity().getApplication())).get(DetayFragmentViewModel.class);
    }

    public void buttonGuncelle(int id, String yapilacak_is){
        viewModel.guncelle(id,yapilacak_is);
         }
}