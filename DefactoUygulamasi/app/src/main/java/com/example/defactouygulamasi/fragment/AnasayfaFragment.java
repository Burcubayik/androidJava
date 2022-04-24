package com.example.defactouygulamasi.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.defactouygulamasi.R;
import com.example.defactouygulamasi.adapter.CategoryAdapter;
import com.example.defactouygulamasi.adapter.ProductAdapter;
import com.example.defactouygulamasi.databinding.FragmentAnasayfaBinding;
import com.example.defactouygulamasi.entity.Category;
import com.example.defactouygulamasi.entity.Product;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);
        tasarim.toolbarAnasayfa.setLogo(R.drawable.defacto_logo);


        tasarim.rvCategory.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<Category> categories = new ArrayList<>();
        Category category1 = new Category(1,"Eşofman Altı");
        Category category2 = new Category(2,"Tişört");
        Category category3 = new Category(3,"Pantolon");
        Category category4 = new Category(4,"Gömlek");
        Category category5 = new Category(5,"Elbise");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);

        CategoryAdapter categoryAdapter = new CategoryAdapter(requireContext(),categories);
        tasarim.rvCategory.setAdapter(categoryAdapter);

        tasarim.rvCard.setLayoutManager((new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)));

        ArrayList<Product> products = new ArrayList<>();
        Product product1 = new Product(1,"Ceket Yaka Relax Fit Kısa Kollu Keten Gömlek","ceket_yaka_relax_keten",149.99,6);
        Product product2 = new Product(2,"Relax Fit Desenli Ceket Yaka Yarım Kollu Gömlek","relax_fit_desenli_ceket_yaka",94.99,0);
        Product product3 = new Product(3,"Oversize Fit Ceket Yaka Blazer","oversize_fit_ceket_yaka_blazer",404.99,0);
        Product product4 = new Product(4,"Gömlek Yaka Keten Görünümlü Yazlık Midi Elbise","gomlek_yaka_keten_gorunumlu_yazlik_midi_elbise",249.99,7);
        Product product5 = new Product(5,"A Kesim Normal Bel Astarlı Tweed Mini Dokuma Etek","a_kesim_normal_bel_astarli_tweed",149.99,1);
        Product product6 = new Product(6,"Crop Blazer","crop_blazer",349.99,5);


        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product1);
        products.add(product2);

        ProductAdapter productAdapter = new ProductAdapter(requireContext(),products);
        tasarim.rvCard.setAdapter(productAdapter);
        tasarim.textViewGosterilenUrun.setText(String.valueOf(products.size())+ " ürün gösteriliyor");

        return tasarim.getRoot();
    }
}