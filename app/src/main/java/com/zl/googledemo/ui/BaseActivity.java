package com.zl.googledemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zl.googledemo.app.AppManager;
import com.zl.googledemo.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ButterKnife.bind(this);//绑定注解控件ButterKnife
        EventBus.getDefault().register(this);//注册事件总线EventBus
        AppManager.getAppManager().addActivity(this);

        initContentView(savedInstanceState);
    }

    protected abstract void initContentView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        EventBus.getDefault().unregister(this);//取消注册事件总线EventBus
    }
    protected abstract int getLayoutView();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public abstract void onEventMainThread(MessageEvent messageEvent);


}
