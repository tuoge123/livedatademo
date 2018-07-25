package com.example.tuoge.pagelistdemo;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource extends ItemKeyedDataSource {

    public int start = 0;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        List<User> list = loadData(start, params.requestedLoadSize);
        callback.onResult(list);
        start += list.size();
    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        List<User> list = loadData(start, params.requestedLoadSize);
        callback.onResult(list);
        start += list.size();
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @NonNull
    @Override
    public Object getKey(@NonNull Object item) {
        return null;
    }

    private List<User> loadData(int startPosition, int count) {
        List<User> list = new ArrayList();
        if (startPosition >= 100) {
            return list;
        }
        for (int i = 0; i < count; i++) {
            User data = new User();
            data.text = startPosition + i + "";
            list.add(data);
            Log.e("text : ", data.text);
        }

        return list;
    }
}
