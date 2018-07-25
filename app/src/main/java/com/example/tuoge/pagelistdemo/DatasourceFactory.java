package com.example.tuoge.pagelistdemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

public class DatasourceFactory extends DataSource.Factory<String, User> {

    public MutableLiveData<UserDataSource> source = new MutableLiveData<>();

    @Override
    public DataSource<String, User> create() {
        UserDataSource myDataSource = new UserDataSource();

        source.postValue(myDataSource);
        return myDataSource;
    }
}
