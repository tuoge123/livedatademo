package com.example.tuoge.pagelistdemo;

import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.LivePagedListProvider;

public abstract class UserDao {
    public abstract LivePagedListBuilder<Integer, User> usersByLastName();

}
