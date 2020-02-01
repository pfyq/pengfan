package com.example.pengfan.seeimage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pengfan.seeimage.MainActivity;
import com.example.pengfan.seeimage.R;
import com.example.pengfan.seeimage.util.Constants;
import com.example.pengfan.seeimage.util.RegexUtil;
import com.example.pengfan.seeimage.util.SharePreferencesUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
//    private SharePreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);

//        sp = SharePreferencesUtil.getInstance(getApplicationContext());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_login:
                login();
                break;
        }
    }

    public void login(){
        //获取用户输入的用户名
        String username = et_username.getText().toString().trim();

        //判断是否输入邮箱
        if (TextUtils.isEmpty(username)){
            Toast.makeText(this,R.string.email_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //通过正则表达式判断邮箱格式是否正确
        if(!RegexUtil.isEmail(username)){
            Toast.makeText(this,R.string.email_error,Toast.LENGTH_SHORT).show();
            return;
        }


        //获取密码
        String password = et_password.getText().toString().trim();

        //判断是否输入密码
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.password_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //判断密码长度
        if (password.length() < 6 || password.length() > 15){
            Toast.makeText(this,R.string.pasword_length_error,Toast.LENGTH_SHORT).show();
            return;
        }


        //判断密码用户名是否正确
        if (Constants.USERNAME.equals(username)&&Constants.PASSWORD.equals(password)){

            //登录成功保存登录记录
            sp.setLogin(true);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            //关闭当前界面
            finish();
        }else {
            Toast.makeText(this,R.string.username_or_password_error,Toast.LENGTH_SHORT).show();
        }
    }

}
