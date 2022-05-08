package com.example.todoapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.entity.YapilacakIsler;
import com.example.todoapp.repo.YapilacakIslerDaoRepository;

import java.util.List;

public class AnasayfaFragmentViewModel extends AndroidViewModel {
    private YapilacakIslerDaoRepository krepo;
    public MutableLiveData<List<YapilacakIsler>> yapilacakIslerListesi = new MutableLiveData();

    public AnasayfaFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new YapilacakIslerDaoRepository(application);
        yapilacaklariYukle();
        yapilacakIslerListesi = krepo.yapilacakIsleriGetir();

    }

    public void yapilacaklariYukle(){
        krepo.tumYapilacaklariAl();
    }

    public void ara(String aramaKelimesi){
        krepo.yapilacakIsAra(aramaKelimesi);
    }
    public void sil(int id){
        krepo.yapilacakIsSil(id);
    }
}
