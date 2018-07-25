package com.example.tuoge.pagelistdemo;

import android.arch.paging.PagedListAdapter;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.MyViewHolder> {
    public UserAdapter() {
        super(User.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(android.R.layout.simple_list_item_2, null);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = getItem(position);
        if (user != null) {
            holder.text1.setText(user.text);
        } else {
            // Null defines a placeholder item - PagedListAdapter will automatically invalidate
            // this row when the actual object is loaded from the database
//            holder.clear();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;

        public MyViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
            text1.setTextColor(Color.RED);
        }
    }
}
