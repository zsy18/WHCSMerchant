package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;

import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/16 16:34
 * 版本：V1.0
 * 修改历史：
 */
public class GoodsCategoryCAdapter extends MyBaseAdapter<String>{
    public GoodsCategoryCAdapter(Context ctx, List dataList) {
        super(ctx,dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView ==null){
            convertView = View.inflate(ctx, R.layout.item_goods_category_c,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvgoodscategoryc.setText(dataList.get(position));
        return convertView;
    }

    public class ViewHolder {
        public final ImageView ivgoodscategoryc;
        public final TextView tvgoodscategoryc;
        public final View root;

        public ViewHolder(View root) {
            ivgoodscategoryc = (ImageView) root.findViewById(R.id.iv_goods_category_c);
            tvgoodscategoryc = (TextView) root.findViewById(R.id.tv_goods_category_c);
            this.root = root;
        }
    }
}
