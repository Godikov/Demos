package com.example.administrator.demos.adapter.baseadapter;

/**
 * Author: Othershe
 * Time: 2016/8/29 10:48
 */
public interface OnItemClickListeners<T> {
    void onItemClick(ViewHolder viewHolder, T data, int position);
}
