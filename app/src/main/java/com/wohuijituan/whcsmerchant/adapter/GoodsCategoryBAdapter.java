package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.activity.GoodsManageActivity;
import com.wohuijituan.whcsmerchant.myview.MyGridViewInListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/16 16:34
 * 版本：V1.0
 * 修改历史：
 */
public class GoodsCategoryBAdapter extends MyBaseAdapter<String>{
    public GoodsCategoryBAdapter(Context ctx, List dataList) {
        super(ctx,dataList);
        stringListC = new ArrayList<>();
        stringListC.addAll(Arrays.asList(mStringsC));
    }
    private String[] mStringsC = { "被子","床品套件","电热毯","毛巾浴巾","浴室用品","电压力锅" };
    List<String> stringListC;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null){
            convertView = View.inflate(ctx, R.layout.item_goods_category_b,null);
            vh = new ViewHolder(convertView);
            //初始化GoodsCategoryC
            vh.cAdapter = new GoodsCategoryCAdapter(ctx,getCCategoryList(position));
            //给ViweHolder中的列表适配器建立联系,并设置适配器
            vh.gvgoodscategoryc.setAdapter(vh.cAdapter);
            vh.gvgoodscategoryc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //TODO 得到需要携带的数据,跳转到商品管理操作的界面
                    Intent intent = new Intent(ctx, GoodsManageActivity.class);
                    ctx.startActivity(intent);
                }
            });
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvgoodscategoryb.setText(dataList.get(position));
        vh.cAdapter.replace(getCCategoryList(position));

        return convertView;
    }
    /**
     * 得到二级列表下的三级种类列表
     * @param position
     * @return 三级种类列表
     */
    private List<String> getCCategoryList(int position) {
        //TODO 得到2级列表下的3级种类列表
        List<String> strings = new ArrayList<>();
        strings.add(position+"");
        strings.addAll(stringListC);
        return strings;
    }
    public class ViewHolder {
        public final TextView tvgoodscategoryb;
        public final MyGridViewInListView gvgoodscategoryc;
        public final View root;
        public GoodsCategoryCAdapter cAdapter;

        public ViewHolder(View root) {
            tvgoodscategoryb = (TextView) root.findViewById(R.id.tv_goods_category_b);
            gvgoodscategoryc = (MyGridViewInListView) root.findViewById(R.id.gv_goods_category_c);
            this.root = root;
        }
    }
}
