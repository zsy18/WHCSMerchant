package com.wohuijituan.whcsmerchant.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/14 15:09
 * 版本：V1.0
 * 修改历史：
 */
public abstract class MyBaseFragment extends Fragment{
    Context ctx;
    Activity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ctx = getContext();
        activity = getActivity();
        return createMyView(inflater,container,savedInstanceState);
    }
    protected abstract View createMyView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState);
    /**
     * 弹出toast
     *
     * @param ctx context
     * @param str 内容
     */
    public static void showToast(Context ctx, String str) {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
    }
}
