package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.UserForm;

@Mapper
public interface UserInfoMapper {

	/**
	 * ユーザーデータを取得する
	 * @param searchForm 検索用データ
	 */
	List<UserInfo> findBySearchForm(UserForm userform);

	/**
	 * ユーザーデータを追加する
	 * @param userData ユーザーデータテーブル(user_data)の追加データ
	 */
	List<UserInfo> createRegisterForm(UserInfo userInfo);

    /**
     * 最大値IDを取得する
     * @return 最大値ID
     */
    String findMaxId();
}
