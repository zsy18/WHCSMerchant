package com.wohuijituan.whcsmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wohuijituan.whcsmerchant.R;

import java.util.List;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/20 9:07
 * 版本：V1.0
 * 修改历史：
 */
public class GoodsListAdapter extends MyBaseAdapter<String> implements View.OnClickListener{
    public GoodsListAdapter(Context ctx, List<String> dataList) {
        super(ctx, dataList);
    }
    private final static int GOODS_SORT_SELlING = 0;
    private final static int GOODS_SORT_UNSHELVE = 1;
    private final static int GOODS_SORT_ADDABLE = 2;

    /**
     * 设置监听,外部必须调用
     * @param myOnItemBtnClickListener
     */
    public void setMyOnItemBtnClickListener(MyOnItemBtnClickListener myOnItemBtnClickListener) {
        this.myOnItemBtnClickListener = myOnItemBtnClickListener;
    }

    private MyOnItemBtnClickListener myOnItemBtnClickListener;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            convertView = View.inflate(ctx, R.layout.item_goods_list,null);
            vh = new ViewHolder(convertView);
            vh.btnGoodsOperate.setOnClickListener(this);
            vh.btnGoodsAdd.setOnClickListener(this);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.btnGoodsAdd.setTag(position);
        vh.btnGoodsOperate.setTag(position);
        int sort = Integer.parseInt(dataList.get(position));
        setGoodsSort(sort, vh);
        return convertView;
    }

    /**
     * 设置商品的类型,正在销售中商品,已下架的商品,可以添加的商品
     * @param sort
     */
    private void setGoodsSort(int sort , ViewHolder viewHolder){
        if(sort == GOODS_SORT_SELlING){
            viewHolder.btnGoodsOperate.setVisibility(View.VISIBLE);
            viewHolder.btnGoodsAdd.setVisibility(View.GONE);
        }else if (sort == GOODS_SORT_UNSHELVE){
            viewHolder.btnGoodsOperate.setVisibility(View.GONE);
            viewHolder.btnGoodsAdd.setVisibility(View.VISIBLE);
            viewHolder.btnGoodsAdd.setText(R.string.goods_un_shelve);
        }else if (sort == GOODS_SORT_ADDABLE){
            viewHolder.btnGoodsOperate.setVisibility(View.GONE);
            viewHolder.btnGoodsAdd.setVisibility(View.VISIBLE);
            viewHolder.btnGoodsAdd.setText(R.string.goods_add);
        }
    }
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();

        if(myOnItemBtnClickListener != null){
            myOnItemBtnClickListener.onClick(position);
        }else {
            showToast(ctx,"没有设置myOnItemBtnClickListener监听");
        }
    }

    /**
     * 监听接口,用来传输被点击控件所在item的position
     */
    public interface MyOnItemBtnClickListener{
        public void onClick(int position);
    }
    public class ViewHolder {
        public final ImageView ivGoodsPicture;
        public final TextView tvGoodsName;
        public final TextView tvGoodsDetail;
        public final TextView tvGoodsPrice;
        public final TextView tvGoodsStore;
        public final TextView tvGoodsSales;
        public final ImageButton btnGoodsOperate;
        public final Button btnGoodsAdd;
        public final View root;

        public ViewHolder(View root) {
            ivGoodsPicture = (ImageView) root.findViewById(R.id.iv_goods_picture);
            tvGoodsName = (TextView) root.findViewById(R.id.tv_goods_name);
            tvGoodsDetail = (TextView) root.findViewById(R.id.tv_goods_detail);
            tvGoodsPrice = (TextView) root.findViewById(R.id.tv_goods_price);
            tvGoodsStore = (TextView) root.findViewById(R.id.tv_goods_store);
            tvGoodsSales = (TextView) root.findViewById(R.id.tv_goods_sales);
            btnGoodsOperate = (ImageButton) root.findViewById(R.id.btn_goods_operate);
            btnGoodsAdd = (Button) root.findViewById(R.id.btn_goods_add);
            this.root = root;
        }
    }


}
