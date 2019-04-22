package com.example.administrator.demos.interfaces;

import android.text.TextUtils;

/**
 * Created by Administrator on 2019/2/28.
 */

public class UserLoginBusiness implements IUserBusiness {

    @Override
    public void login(String name, String pwd, LoginListener loginListener) {
        if(TextUtils.isEmpty(name)){
           return;
        }
        if(TextUtils.isEmpty(pwd)){
            return;
        }
        if(Math.random() > 0.5){
            loginListener.loginSuccess();
        }else{
            loginListener.loginFailure();
        }
    }

}
