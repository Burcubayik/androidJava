package com.example.todoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "yapilacaklar")
public class YapilacakIsler implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacak_id")
    @NonNull
    private int id;
    @ColumnInfo(name = "yapilacak_is")
    @NonNull
    private String yapilacak_is;

    public YapilacakIsler() {
    }

    public YapilacakIsler(int id, String yapilacak_is) {
        this.id = id;
        this.yapilacak_is = yapilacak_is;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYapilacak_is() {
        return yapilacak_is;
    }

    public void setYapilacak_is(String yapilacak_is) {
        this.yapilacak_is = yapilacak_is;
    }
}
