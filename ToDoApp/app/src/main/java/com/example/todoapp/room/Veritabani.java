package com.example.todoapp.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todoapp.entity.YapilacakIsler;

@Database(entities = {YapilacakIsler.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract YapilacakIslerDao yapilacakIslerDao();
    public static Veritabani INSTANCE;

    public static Veritabani veritabaniErişim(Context context){
        if(INSTANCE == null){
            synchronized (Veritabani.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),Veritabani.class,"toDoApp.sqlite")
                        .createFromAsset("toDoApp.sqlite").build();
            }
        }
        return INSTANCE;
    }

}
