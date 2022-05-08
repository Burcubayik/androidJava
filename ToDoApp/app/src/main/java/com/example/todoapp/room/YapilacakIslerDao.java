package com.example.todoapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapp.entity.YapilacakIsler;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacakIslerDao {
    @Query("SELECT * FROM yapilacaklar")
    Single<List<YapilacakIsler>> tumYapilacaklar();

    @Insert
    Completable isEkle(YapilacakIsler yapilacakIs);

    @Update
    Completable isGuncelle(YapilacakIsler yapilacakIs);

    @Delete
    Completable isSil(YapilacakIsler yapilacakIs);

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%'|| :aramaKelimesi ||'%'")
    Single<List<YapilacakIsler>> isArama(String aramaKelimesi);
}
