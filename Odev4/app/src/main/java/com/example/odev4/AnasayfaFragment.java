package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentAnasayfaBinding;



public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);
        tasarim.buttonGitA.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.aSayfasinaGecis);
        });
        tasarim.buttonGitX.setOnClickListener(view ->{

            Navigation.findNavController(view).navigate(R.id.xSayfasinaGecis);
        });
        return tasarim.getRoot();
    }
} 