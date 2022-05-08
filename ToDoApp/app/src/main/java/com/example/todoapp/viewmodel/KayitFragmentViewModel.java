package com.example.todoapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.repo.YapilacakIslerDaoRepository;

public class KayitFragmentViewModel extends AndroidViewModel {
    private YapilacakIslerDaoRepository krepo;

    public KayitFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new YapilacakIslerDaoRepository(application);
    }

    public void kayit(String yapilacak_is){
        krepo.yapilacakIsKayit(yapilacak_is);
    }
}
