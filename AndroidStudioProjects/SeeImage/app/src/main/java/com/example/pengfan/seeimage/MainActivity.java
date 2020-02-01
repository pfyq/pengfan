package com.example.pengfan.seeimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pengfan.seeimage.activity.BaseActivity;
import com.example.pengfan.seeimage.activity.LoginActivity;
import com.example.pengfan.seeimage.util.SharePreferencesUtil;

public class MainActivity extends BaseActivity {

//    private SharePreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
//        sp = SharePreferencesUtil.getInstance(getApplicationContext());


        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        rv.setLayoutManager(layoutManager);
    }

    /*
    * 退出
    * */
    public void onLogoutClick(View view) {
        sp.setLogin(false);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
