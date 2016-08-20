package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.utils.LogUtils;

import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/16 16:30
 * 版本：V1.0
 * 修改历史：
 */
public class GoodsCategoryAAdapter extends MyBaseAdapter<String>{
    private static final String TAG = "GoodsCategoryAAdapter";
    private int checkID = 0;
    public GoodsCategoryAAdapter(Context ctx, List<String> dataList) {
        super(ctx ,dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null){
            convertView = View.inflate(ctx, R.layout.item_goods_category_a,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        if(position == checkID){
            convertView.setBackgroundColor(ctx.getResources().getColor(R.color.colorAccent));
        }else {
            convertView.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));
        }
        vh.tvgoodscategorya.setText(dataList.get(position));
        LogUtils.e(TAG,"getView:"+position);
        return convertView;
    }

    /**
     * 通过设置checkID,然后进行通知重绘页面
     * @param position
     */
    public void setCheckStyle(int position){
        //TODO 改变position所在view样子
        checkID = position;
        notifyDataSetChanged();
    }
    public class ViewHolder {
        public final ImageView ivgoodscategorya;
        public final TextView tvgoodscategorya;
        public final View root;

        public ViewHolder(View root) {
            ivgoodscategorya = (ImageView) root.findViewById(R.id.iv_goods_category_a);
            tvgoodscategorya = (TextView) root.findViewById(R.id.tv_goods_category_a);
            this.root = root;
        }
    }
}
