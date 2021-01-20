package com.example.postwithroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Observable;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleConverter;

@Dao
public interface PostsDao {
    @Insert
    Completable insertPost(Post post);
    @Query("select * from posts_table")
   Single<List<Post>> getPosts();
}
