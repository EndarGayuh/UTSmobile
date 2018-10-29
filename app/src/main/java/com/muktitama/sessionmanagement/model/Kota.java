package com.muktitama.sessionmanagement.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tkota")
public class Kota implements Serializable {

    public int getIdKota() {
        return IdKota;
    }

    public void setIdKota(int idKota) {
        IdKota = idKota;
    }

    @PrimaryKey(autoGenerate = true)
    public int IdKota;

    @ColumnInfo
    public String nama_kota;

    public String getNama_kota() {
        return nama_kota;
    }

    public void setNama_kota(String nama_kota) {
        this.nama_kota = nama_kota;
    }
}
