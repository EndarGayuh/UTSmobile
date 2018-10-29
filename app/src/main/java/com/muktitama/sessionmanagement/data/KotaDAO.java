package com.muktitama.sessionmanagement.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.muktitama.sessionmanagement.model.Kota;

@Dao
public interface KotaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertKota(Kota kota);

    @Update
    int updateKota(Kota kota);

    @Delete
    int deleteBuku(Kota kota);

    @Query("SELECT * FROM tkota")
    Kota[] selectAllKota();

    @Query("SELECT * FROM tkota WHERE nama_kota = :id LIMIT 1")
    Kota selectKotaDetail(int id);
}
