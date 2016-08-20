package com.wohuijituan.whcsmerchant.activity;


import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.fragment.GoodsFragment;
import com.wohuijituan.whcsmerchant.fragment.OrderFragment;
import com.wohuijituan.whcsmerchant.fragment.SettingFragment;
import com.wohuijituan.whcsmerchant.fragment.ShopFragment;

public class HomeActivity extends MyBaseActivity {
    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    //定义一个布局
    private LayoutInflater layoutInflater;
    //定义数组来存放Fragment界面
    private Class fragmentArray[] =
            {OrderFragment.class,GoodsFragment.class,ShopFragment.class,SettingFragment.class};
    //定义数组来存放按钮图片
    private int mImageViewArray[] =
            {R.drawable.tab_icon_dingdan_selected,
            R.drawable.tab_icon_dingdan_selected,
            R.drawable.tab_icon_dingdan_selected,
            R.drawable.tab_icon_dingdan_selected};
    //Tab选项卡的文字
    private String mTextviewArray[] = {"订单处理", "商品管理", "门店管理", "设置"};
    private FrameLayout flContent;


    private void assignViews() {
        flContent = (FrameLayout) findViewById(R.id.fl_content);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        assignViews();
        initView();
    }

    private void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);

        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.colorAccent);
        }
    }
    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_main, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_home_tab);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_home_tab);
        textView.setText(mTextviewArray[index]);
        return view;
    }
}
