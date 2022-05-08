package com.example.todoapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapp.R;
import com.example.todoapp.adapter.YapilacakIslerAdapter;
import com.example.todoapp.databinding.FragmentAnasayfaBinding;
import com.example.todoapp.entity.YapilacakIsler;
import com.example.todoapp.viewmodel.AnasayfaFragmentViewModel;
import com.example.todoapp.viewmodel.AnasayfaVMF;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnasayfaBinding tasarim;
    private AnasayfaFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);
        tasarim.setAnasayfaFragment(this);
        tasarim.setAnasayfaToolbarBaslik("Yapılacaklar");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);
        viewModel.yapilacakIslerListesi.observe(getViewLifecycleOwner(),liste ->{
            YapilacakIslerAdapter adapter = new YapilacakIslerAdapter(requireContext(),liste,viewModel);
            tasarim.setYapilacakIslerAdapter(adapter);
        });


        return tasarim.getRoot();

    }
    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.kayitGecis);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this, new AnasayfaVMF(requireActivity().getApplication())).get(AnasayfaFragmentViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yapilacaklariYukle();
    }
}