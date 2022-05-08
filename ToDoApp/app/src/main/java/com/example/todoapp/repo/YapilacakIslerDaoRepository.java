package com.example.todoapp.repo;

import android.app.Application;
import android.hardware.lights.LightState;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.todoapp.entity.YapilacakIsler;
import com.example.todoapp.room.Veritabani;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacakIslerDaoRepository {
    private MutableLiveData<List<YapilacakIsler>> yapilacakIslerListesi;
    private Veritabani vt;
    public YapilacakIslerDaoRepository(Application application) {
        yapilacakIslerListesi = new MutableLiveData();
        vt = Veritabani.veritabaniErişim(application);
    }

    public MutableLiveData<List<YapilacakIsler>> yapilacakIsleriGetir() {
        return yapilacakIslerListesi;
    }

    public void yapilacakIsKayit(String yapilacak_is){
        YapilacakIsler yeniIs = new YapilacakIsler(0,yapilacak_is);
        vt.yapilacakIslerDao().isEkle(yeniIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Kayıt","Başarılı");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void yapilacakIsGuncelle(int id, String yapilacak_is){
        YapilacakIsler guncellenenIs = new YapilacakIsler(id,yapilacak_is);
                vt.yapilacakIslerDao().isGuncelle(guncellenenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Güncelleme","Başarılı");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void yapilacakIsAra(String aramaKelimesi){
        Disposable disposable = vt.yapilacakIslerDao().isArama(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste ->{
                    yapilacakIslerListesi.setValue(liste);
                });
    }
    public void yapilacakIsSil(int id){
        YapilacakIsler silinenIs = new YapilacakIsler(id,"");

        vt.yapilacakIslerDao().isSil(silinenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Silme","Başarılı");
                        tumYapilacaklariAl();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void tumYapilacaklariAl(){
        Disposable disposable = vt.yapilacakIslerDao().tumYapilacaklar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste ->{
                    yapilacakIslerListesi.setValue(liste);
                });

    }
}
