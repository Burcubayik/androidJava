package com.example.todoapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.repo.YapilacakIslerDaoRepository;

public class DetayFragmentViewModel extends AndroidViewModel {
    private YapilacakIslerDaoRepository krepo;

    public DetayFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new YapilacakIslerDaoRepository(application);
    }

    public void guncelle(int id, String yapilacak_is){
      krepo.yapilacakIsGuncelle(id, yapilacak_is);
    }
}
