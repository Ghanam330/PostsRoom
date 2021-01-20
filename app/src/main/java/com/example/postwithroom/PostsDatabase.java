package com.example.postwithroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = Post.class,version = 2)
@TypeConverters(Converters.class)
public abstract class PostsDatabase extends RoomDatabase {
    private static PostsDatabase instance;

    public abstract PostsDao postsDao();

    public static PostsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PostsDatabase.class, "posts_datebase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
