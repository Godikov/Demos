package com.example.administrator.demos.interfaces;

import android.util.Log;

import com.example.administrator.demos.util.LogUtil;

/**
 * Created by Administrator on 2019/2/28.
 */

public class UserLoginViewPresenter {

    private UserLoginView userLoginView;
    private UserLoginBusiness loginBusiness;

    public UserLoginViewPresenter(UserLoginView userLoginView){
        this.userLoginView = userLoginView;
        loginBusiness = new UserLoginBusiness();
    }

    public void login(){
        loginBusiness.login(userLoginView.getUsername(), userLoginView.getUserpwd(), new LoginListener() {
            @Override
            public void loginSuccess() {
                Log.d("LOGIN","loginSuccess: "+userLoginView.getUsername()+" "+userLoginView.getUserpwd());
                userLoginView.clearUsername();
                userLoginView.clearPwd();
            }

            @Override
            public void loginFailure() {
                Log.d("LOGIN","loginFailure: "+userLoginView.getUsername()+" "+userLoginView.getUserpwd());
                userLoginView.clearUsername();
                userLoginView.clearPwd();
            }
        });
    }

    public void clear(){
        userLoginView.clearUsername();
        userLoginView.clearPwd();
    }

}
