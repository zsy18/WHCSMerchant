package com.wohuijituan.whcsmerchant.fragment;


import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.adapter.GoodsCategoryAAdapter;
import com.wohuijituan.whcsmerchant.adapter.GoodsCategoryBAdapter;
import com.wohuijituan.whcsmerchant.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link MyBaseFragment} subclass.
 */
public class GoodsFragment extends MyBaseFragment {


    public GoodsFragment() {
        // Required empty public constructor
    }

    private static final String TAG = "GoodsFragment";
    private ListView lvGoodsCategoryA;
    private ListView lvGoodsCategoryB;
    private ArrayList<String> mListItemsA;
    private GoodsCategoryAAdapter mAdapterA;
    private String[] mStringsA = {"进口食品","粮油副食","美容洗护","家具家电","家庭清理","母婴用品","生活服务"};
    private ArrayList<String> mListItemsB;
    private GoodsCategoryBAdapter mAdapterB;
    private String[] mStringsB = {"家纺","家居用品","厨房电器","厨房用品","个人护理","母婴","地方特产"};

    private void assignViews(View v) {
        lvGoodsCategoryA = (ListView) v.findViewById(R.id.lv_goods_category_a);
        lvGoodsCategoryB = (ListView) v.findViewById(R.id.lv_goods_category_b);
    }


    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_goods, container, false);
        assignViews(v);
        iniData();
        initView();
        initListener();

        mListItemsB.addAll(Arrays.asList(mStringsB));

        lvGoodsCategoryB.setAdapter(mAdapterB);
        return v;
    }

    private void iniData() {
        //给a列表添加数据
        mListItemsA = new ArrayList<>();
        mListItemsA.addAll(Arrays.asList(mStringsA));
        mAdapterA = new GoodsCategoryAAdapter(ctx,mListItemsA);
        lvGoodsCategoryA.setAdapter(mAdapterA);
        //初始化b列表
        mListItemsB = new ArrayList<>();
        mListItemsB.addAll(Arrays.asList(mStringsB));
        mAdapterB = new GoodsCategoryBAdapter(ctx,mListItemsB);
        lvGoodsCategoryB.setAdapter(mAdapterB);
    }

    private void initView(){

    }
    private void initListener(){
        //给列表a添加监听
        lvGoodsCategoryA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapterA.setCheckStyle(position);//设置选中状态样式
                List<String> strings = getBCategoryList(position);//获取对应一级下的二级列表
                mAdapterB.replace(strings);//替换mAdapterB中数据
                LogUtils.e(TAG,"position:"+position);
                lvGoodsCategoryB.setSelection(0);//b列表回到顶部
            }
        });
    }

    /**
     * 得到一级列表下的二级种类列表
     * @param position
     * @return 二级种类列表
     */
    private List<String> getBCategoryList(int position) {
        //TODO 得到一级列表下的二级种类列表
        List<String> strings = new ArrayList<>();
//        strings.add(position+"");
        strings.addAll(mListItemsB);
        return strings;
    }

}
