package com.wohuijituan.whcsmerchant.fragment;


import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.adapter.GoodsListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsOnsellFragment extends MyBaseFragment {


    public GoodsOnsellFragment() {
        // Required empty public constructor
    }
    String[] strings = {"0","0","0","0","0","0","0","0","0","0","0","0"};
    private GoodsListAdapter goodsListAdapter;
    private PullToRefreshListView pullGoodsList;
    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_goods_list, container, false);
        pullGoodsList = (PullToRefreshListView) v.findViewById(R.id.pull_goods_list);
        List<String> goodsList = new ArrayList<>();
        goodsList.addAll(Arrays.asList(strings));
        goodsListAdapter = new GoodsListAdapter(ctx,goodsList);
        pullGoodsList.setAdapter(goodsListAdapter);
        return v;
    }

}
