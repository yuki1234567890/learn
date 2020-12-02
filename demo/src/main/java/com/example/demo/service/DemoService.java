package com.example.demo.service;

import java.util.List;

import com.example.demo.form.UserForm;

public interface  DemoService {

    /**
     * ユーザーデータリストを取得
     * @param searchForm 検索用Formオブジェクト
     * @return ユーザーデータリスト
     */
    List<UserForm> demoFormList(UserForm userForm);

    /**
     * 引数のユーザーデータ追加
     * @param demoForm フォームオブジェクト
     */
    void create(UserForm userForm);
}
