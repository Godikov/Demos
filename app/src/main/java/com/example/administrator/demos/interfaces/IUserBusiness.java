package com.example.administrator.demos.interfaces;

/**
 * Created by Administrator on 2019/2/28.
 */

public interface IUserBusiness {

    void login(String name,String pwd,LoginListener loginListener);

}
