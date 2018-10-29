package com.muktitama.sessionmanagement.data.factory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.muktitama.sessionmanagement.data.KotaDAO;
import com.muktitama.sessionmanagement.model.Kota;

@Database(entities = {Kota.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract KotaDAO kotaDAO();

}
