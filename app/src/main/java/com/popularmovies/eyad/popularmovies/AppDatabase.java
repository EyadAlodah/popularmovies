package com.popularmovies.eyad.popularmovies;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;


@Database(entities = {Favorites.class} , version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  private static final String LOG_TAG = AppDatabase.class.getSimpleName();
  private static final Object LOCK = new Object();
  private static final String DATABASE_NAME = "favoriteslist";
  private static AppDatabase sInstance;


  public static AppDatabase getInstance(Context context)
  {
    if(sInstance == null)
    {
      synchronized (LOCK){
        Log.v(LOG_TAG,"Createing Database");
        sInstance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, DATABASE_NAME).build();
      }
    }
    return sInstance;
  }

  public abstract FavoritesDao favoritesDao();
}
