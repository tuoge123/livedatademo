package com.example.tuoge.pagelistdemo;

import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.LivePagedListProvider;
import android.arch.paging.PagedList;

public class UserDaoImp extends UserDao {
    @Override
    public LivePagedListBuilder<Integer, User> usersByLastName() {
        LivePagedListBuilder builder = new LivePagedListBuilder(new DatasourceFactory()
                , new PagedList.Config.Builder()
                .setPageSize(50)
                .setPrefetchDistance(50)
                .build());
        return builder;
    }
}
