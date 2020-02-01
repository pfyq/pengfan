package com.example.pengfan.seeimage.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferencesUtil {

    private static  final String TAG = "TAG";
    private static  final String KEY_LOGIN = "KEY_LOGIN";

    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SharePreferencesUtil mSharePreferencesUtil;
    private final Context context;


    public SharePreferencesUtil(Context context) {
        this.context = context.getApplicationContext();
        mPreferences = this.context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

    }

    /*
    * 单例简单实现(应为android中没有Java Web那样的高并发,所以单例可以这样简单实现)
    * */

    public static SharePreferencesUtil getInstance(Context context){

        if (mSharePreferencesUtil == null){
            mSharePreferencesUtil = new SharePreferencesUtil(context);
        }
        return  mSharePreferencesUtil;
    }

    /*
    * 判断是否登录
    * */

    public  boolean isLogin(){
        return getBoolean(KEY_LOGIN,false);
    }

    /*
    * 更新登录状态
    * */
    public  void setLogin(boolean value){
        putBoolean(KEY_LOGIN,value);
    }

    private void put(String key,String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }

    private void putBoolean(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }

    private String get(String key){
        return mPreferences.getString(key,"");
    }

    private boolean getBoolean(String key,boolean defaultValue){
        return mPreferences.getBoolean(key,defaultValue);
    }

    private void putInt(String key,int value){
        mEditor.putInt(key,value);
        mEditor.commit();
    }

    private int getInt(String key,int defaultValue){
        return mPreferences.getInt(key,defaultValue);
    }

}
