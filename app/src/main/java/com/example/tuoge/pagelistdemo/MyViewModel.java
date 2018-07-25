package com.example.tuoge.pagelistdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Executors;

public class MyViewModel extends AndroidViewModel {

    public LiveData<PagedList<User>> usersList;

    public MyViewModel(Application context) {
        super(context);
        PagedList.Config pageConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(5)
                .setPageSize(10).build();
        usersList = (new LivePagedListBuilder<Long, User>(new DataSource.Factory<Long, User>() {
            @Override
            public DataSource<Long, User> create() {
                MutableLiveData<UserDataSource> source = new MutableLiveData<>();
                UserDataSource myDataSource = new UserDataSource();

                source.postValue(myDataSource);
                return myDataSource;
            }
        }, pageConfig)).build();
    }
}
