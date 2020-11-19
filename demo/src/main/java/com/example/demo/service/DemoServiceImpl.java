package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.UserForm;
import com.example.demo.mapper.UserInfoMapper;

@Service
public class DemoServiceImpl implements DemoService{

    /**
     * ユーザー情報テーブルへアクセスするマッパー
     */
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public List<UserForm> demoFormList(UserForm userForm) {
        List<UserForm> demoFormList = new ArrayList<>();
        //ユーザー情報テーブルから検索条件に合うデータを取得する
        List<UserInfo> userInfoList = mapper.findBySearchForm(userForm);
        for (UserInfo userInfo : userInfoList) {
            demoFormList.add(getDemoForm(userInfo));
        }
        return demoFormList;
    }

    /**
     * UserInfoオブジェクトに引数のユーザーデータの各値を設定する
     * @param userInfo ユーザー情報
     * @return UserInfoオブジェクト
     */
    private UserForm getDemoForm(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserForm demoForm = new UserForm();
        demoForm.setId(String.valueOf(userInfo.getId()));
        demoForm.setName(userInfo.getName());
        demoForm.setSex(userInfo.getSex());
        return demoForm;
    }

    @Override
    public void create(UserForm userForm){
        //追加処理を行うエンティティを生成
        UserInfo userInfo = getUserData(userForm);
        //追加処理
        userInfo.setId(String.valueOf(Integer.parseInt(mapper.findMaxId()) + 1));
        mapper.createRegisterForm(userInfo);
    }

    /**
     * UserInfoオブジェクトに引数のフォームの各値を設定する
     * @param userForm UserInfoオブジェクト
     * @return ユーザーデータ
     */
    private UserInfo getUserData(UserForm userForm){
    	UserInfo userInfo = new UserInfo();
        userInfo.setName(userForm.getName());
        userInfo.setSex(userForm.getSex());
        return userInfo;
    }
}

