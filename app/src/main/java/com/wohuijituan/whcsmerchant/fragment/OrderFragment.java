package com.wohuijituan.whcsmerchant.fragment;



import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.viewpagerindicator.TabPageIndicator;
import com.wohuijituan.whcsmerchant.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends MyBaseFragment {

    /**
     * Tab标题
     */
    private static final String[] TITLE = new String[] {"未完成","已完成"};
    private List<Fragment> fragmentList;
    private TabPageIndicator indicator;
    private ViewPager pager;

    private void assignViews(View v) {
        indicator = (TabPageIndicator) v.findViewById(R.id.indicator_order);
        pager = (ViewPager) v.findViewById(R.id.pager_order);
    }

    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        assignViews(v);
        initView();
        return v;
    }

    private void initView() {
        //ViewPager的adapter
        fragmentList = new ArrayList<>();
        fragmentList.add(new OrderUndoneFragment());
        fragmentList.add(new OrderDoneFragment());
        FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(
                getChildFragmentManager(),fragmentList);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager,0);
    }
    /**
     * ViewPager适配器
     * @author len
     */
    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        public TabPageIndicatorAdapter(FragmentManager fm ,List<Fragment> dataList) {
            super(fm);
            list = dataList;
        }

        @Override
        public Fragment getItem(int position) {

            return list.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
