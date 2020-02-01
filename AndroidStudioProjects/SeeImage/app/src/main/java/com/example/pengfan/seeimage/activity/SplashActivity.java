package com.example.pengfan.seeimage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.example.pengfan.seeimage.MainActivity;
import com.example.pengfan.seeimage.R;
import com.example.pengfan.seeimage.util.SharePreferencesUtil;

public class SplashActivity extends BaseActivity {

//    private SharePreferencesUtil sp;

    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            next();
        }
    };

    private void next() {
        Intent intent = null;
        if(sp.isLogin()){
            intent = new Intent(this,MainActivity.class);
        }else{
            intent = new Intent(this,LoginActivity.class);
        }


        startActivity(intent);
        
        //关闭当前界面
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        sp = SharePreferencesUtil.getInstance(getApplicationContext());

        //去掉窗口状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                //3秒后调用,这里调用是在子线程中，不能直接接触UI,需要用handler切换到主线程
                //用多个线程的目的解决,如果有耗时任务,那么就会卡界面
                //而用了多线程后,将耗时任务放到子线程,这样住线程在（UI线程）就不会卡主
                handle.sendEmptyMessage(0);
            }
        },3000);
    }
}
