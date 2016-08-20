package com.wohuijituan.whcsmerchant.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wohuijituan.whcsmerchant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends MyBaseFragment {


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

}
