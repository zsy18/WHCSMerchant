package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.myview.MyListViewInListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/19 10:59
 * 版本：V1.0
 * 修改历史：
 */
public class OrderListAdapter extends MyBaseAdapter<String> implements View.OnClickListener{
    public OrderListAdapter(Context ctx, List<String> dataList) {
        super(ctx, dataList);
    }
    private String[] goodsStrings = {"鸡蛋卷","香肠","黄金叶","雪花啤酒"};
    private final int ORDER_STATE_UNRECEIVE = 0;//未接单状态
    private final int ORDER_STATE_PREPARE = 1;//备货状态
    private final int ORDER_STATE_DONE = 2;//已完成状态

    public void setItemBtnClickListener(MyOnItemBtnClickListener itemBtnClickListener) {
        this.itemBtnClickListener = itemBtnClickListener;
    }

    private MyOnItemBtnClickListener itemBtnClickListener;//一定要记得设置,否则会发生错误

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            convertView = View.inflate(ctx, R.layout.item_order_list,null);
            vh = new ViewHolder(convertView);
            vh.btnorderreceive.setOnClickListener(this);
            vh.btnorderreceive.setTag(position);//给确认收货按钮添加Tag
            convertView.setTag(vh);

        }else {
            vh = (ViewHolder) convertView.getTag();
            vh.btnorderreceive.setTag(position);
        }
        //给订单中的商品列表设置适配器
        if (vh.itemGoodsAdapter == null) {
            List<String> goodsList = new ArrayList<>();
            goodsList.addAll(Arrays.asList(goodsStrings));
            vh.itemGoodsAdapter = new ItemGoodsAdapter(ctx,goodsList);
            vh.lvOrderGoodsItem.setAdapter(vh.itemGoodsAdapter);

        } else {
            List<String> goodsList = new ArrayList<>();
            goodsList.addAll(Arrays.asList(goodsStrings));
            vh.itemGoodsAdapter.replace(goodsList);
        }
        setOrderState(ORDER_STATE_UNRECEIVE,vh);
        vh.tvordernumber.setText("No."+position+1);
        return convertView;
    }

    /**
     * 设置订单状态
     * @param orderState 0为未接单订单,1为准备发货订单,2为已完成订单
     * @param vh
     */
    private void setOrderState(int orderState,ViewHolder vh){
        if(orderState == ORDER_STATE_UNRECEIVE){
            vh.btnorderreceive.setVisibility(View.VISIBLE);
            vh.tvorderprepare.setVisibility(View.GONE);
        }else if (orderState == ORDER_STATE_PREPARE){
            vh.btnorderreceive.setVisibility(View.GONE);
            vh.tvorderprepare.setVisibility(View.VISIBLE);
            vh.tvorderprepare.setText(R.string.order_state_prepare);
        }else if (orderState == ORDER_STATE_DONE){
            vh.btnorderreceive.setVisibility(View.GONE);
            vh.tvorderprepare.setVisibility(View.VISIBLE);
            vh.tvorderprepare.setText(R.string.order_state_done);
        }
    }

    @Override
    public void onClick(View v) {
        int positon = (int) v.getTag();
        if(itemBtnClickListener != null){
            itemBtnClickListener.onClick(positon);

        }else {
            showToast(ctx,"没有设置itemBtnClickListener监听");
        }
    }

    /**
     * 监听接口,用来传输被点击控件所在item的position
     */
    public interface MyOnItemBtnClickListener{
        public void onClick(int position);
    }
    public class ViewHolder {
        public final TextView tvordernumber;
        public final TextView tvordertime;
        public final TextView tvordername;
        public final TextView tvorderaddress;
        public final TextView tvorderprice;
        public final Button btnorderreceive;
        public final TextView tvorderprepare;
        public ItemGoodsAdapter itemGoodsAdapter;
        public final MyListViewInListView lvOrderGoodsItem;
        public final View root;

        public ViewHolder(View root) {
            tvordernumber = (TextView) root.findViewById(R.id.tv_order_number);
            tvordertime = (TextView) root.findViewById(R.id.tv_order_time);
            tvordername = (TextView) root.findViewById(R.id.tv_order_name);
            tvorderaddress = (TextView) root.findViewById(R.id.tv_order_address);
            tvorderprice = (TextView) root.findViewById(R.id.tv_order_price);
            btnorderreceive = (Button) root.findViewById(R.id.btn_order_receive);
            tvorderprepare = (TextView) root.findViewById(R.id.tv_order_prepare);
            lvOrderGoodsItem = (MyListViewInListView) root.findViewById(R.id.lv_order_goods_list);
            this.root = root;
        }
    }
}
