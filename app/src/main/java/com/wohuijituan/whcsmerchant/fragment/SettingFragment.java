package com.wohuijituan.whcsmerchant.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wohuijituan.whcsmerchant.R;

/**
 * A simple {@link MyBaseFragment} subclass.
 */
public class SettingFragment extends MyBaseFragment {


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View createMyView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

}
