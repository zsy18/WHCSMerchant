package com.wohuijituan.whcsmerchant.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;
import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.fragment.GoodsAddFragment;
import com.wohuijituan.whcsmerchant.fragment.GoodsOnsellFragment;
import com.wohuijituan.whcsmerchant.fragment.GoodsUnsellFragment;

import java.util.ArrayList;
import java.util.List;

public class GoodsManageActivity extends MyBaseActivity {

    /**
     * Tab标题
     */
    private static final String[] TITLE = new String[] {"出售中","已下架","去添加"};
    private List<Fragment> fragmentList;
    private TabPageIndicator indicator;
    private ViewPager pager;



    private void assignViews() {
        indicator = (TabPageIndicator) findViewById(R.id.indicator_goods_manager);
        pager = (ViewPager) findViewById(R.id.pager_goods_manager);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_goods);
        assignViews();
        initView();
    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new GoodsOnsellFragment());
        fragmentList.add(new GoodsUnsellFragment());
        fragmentList.add(new GoodsAddFragment());
        FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(
                getSupportFragmentManager(),fragmentList);
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
