package com.example.pengfan.seeimage.activity;

import com.example.pengfan.seeimage.util.SharePreferencesUtil;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {


    protected SharePreferencesUtil sp;

    /*
    * 重写了setContentView方法
    * 因为在子类调用了setContentView设置布局
    * */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        //配置文件
        sp = SharePreferencesUtil.getInstance(getApplicationContext());
    }
}
