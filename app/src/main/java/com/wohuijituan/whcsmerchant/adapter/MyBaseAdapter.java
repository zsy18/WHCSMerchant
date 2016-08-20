package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.wohuijituan.whcsmerchant.utils.LogUtils;

import java.util.List;

/**
 * 说明：Adapter的基类
 * 作者：陈杰宇
 * 时间： 2016/1/27 10:59
 * 版本：V1.0
 * 修改历史：
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private static final String TAG = "MyBaseAdapter";
    public List<T> dataList;
    public Context ctx;

    public MyBaseAdapter(Context ctx,List<T> dataList) {
        this.dataList = dataList;
        this.ctx = ctx;
    }

    public MyBaseAdapter(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 清楚当前list中数据
     */
    public void clear(){
        dataList.clear();
        notifyDataSetChanged();
    }
    /**
     * 替换当前list中数据
     */
    public void replace(List<T> newList){
        dataList.clear();
        LogUtils.e(TAG,"size:"+dataList.size());
        dataList.addAll(newList);
        notifyDataSetChanged();
    }
    /**
     * 向当前list添加一条数据
     */
    public void add(T data){
        dataList.add(data);
        LogUtils.e(TAG, "" + dataList.size());
        notifyDataSetChanged();
    }
    /**
     * 向当前list添加一组数据
     */
    public void addAll(List<T> addList){
        dataList.addAll(addList);
        notifyDataSetChanged();
    }
    /**
     * 弹出toast
     *
     * @param ctx context
     * @param str 内容
     */
    public static void showToast(Context ctx, String str) {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
    }
}
