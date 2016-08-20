package com.wohuijituan.whcsmerchant.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.adapter.OrderListAdapter;
import com.wohuijituan.whcsmerchant.utils.LogUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderUndoneFragment extends MyBaseFragment {
    private static final String TAG = "OrderUndoneFragment";
    private Context ctx;
    private PullToRefreshListView myPullListView;
    private LinkedList<String> mListItems;
    private OrderListAdapter mAdapter;
    private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler" };



    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ctx = getContext();
        View v = inflater.inflate(R.layout.fragment_order_undone, container, false);
        myPullListView = (PullToRefreshListView) v.findViewById(R.id.pull_refresh_list_order_undone);
        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        mAdapter = new OrderListAdapter(ctx,mListItems);
        mAdapter.setItemBtnClickListener(new OrderListAdapter.MyOnItemBtnClickListener() {
            @Override
            public void onClick(int position) {
                LogUtils.e(TAG,position+"");
            }
        });
        myPullListView.setAdapter(mAdapter);
        return v;
    }


}
