package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;

import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/19 11:16
 * 版本：V1.0
 * 修改历史：
 */
public class ItemGoodsAdapter extends MyBaseAdapter<String>{
    public ItemGoodsAdapter(Context ctx, List<String> dataList) {
        super(ctx, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null){
            convertView = View.inflate(ctx, R.layout.item_order_list_goods,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvitemgoodsname.setText(dataList.get(position));
        return convertView;
    }

    public class ViewHolder {
        public final TextView tvitemgoodsname;
        public final TextView tvitemgoodsprice;
        public final View root;

        public ViewHolder(View root) {
            tvitemgoodsname = (TextView) root.findViewById(R.id.tv_item_goods_name);
            tvitemgoodsprice = (TextView) root.findViewById(R.id.tv_item_goods_price);
            this.root = root;
        }
    }
}
