package com.wohuijituan.whcsmerchant.activity;

import android.annotation.TargetApi;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.wohuijituan.whcsmerchant.R;
import com.wohuijituan.whcsmerchant.utils.SystemBarTintManager;

/**
 * 说明：
 * 作者：朱世元
 * 时间： 2016/8/14 15:08
 * 版本：V1.0
 * 修改历史：
 */
public class MyBaseActivity extends FragmentActivity {
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleColor();
    }

    /**
     * 设定标题栏颜色
     */
    public void titleColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorAccent);//通知栏所需颜色
        }
    }
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    /**
     * 弹出toast
     *
     * @param ctx context
     * @param str 内容
     */
    public void showToast(Context ctx, String str) {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
    }
}
