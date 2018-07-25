package com.example.tuoge.pagelistdemo;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.util.Log;

public class User {
    public String text;

    public static final DiffUtil.ItemCallback<User>

            DIFF_CALLBACK = new DiffUtil.ItemCallback<User>() {

        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            boolean f = oldItem.text.equals(newItem.text);
//            Log.e("areItemsTheSame", f + "");

            return f;
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            boolean f = oldItem.text.equals(newItem.text);

//            Log.e("areContentsTheSame", f + "");

            return f;
        }
    };
}
