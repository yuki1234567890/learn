package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.UserForm;
import com.example.demo.service.DemoService;


@Controller
@SessionAttributes(types = {UserForm.class})
public class DemoController {

    /**
     * Demoサービスクラスへのアクセス
     */
    @Autowired
    private DemoService demoService;

    /**
     * ユーザー情報テーブルのデータを取得して返却する
     * @return ユーザーデータリスト
     */
    @ModelAttribute("demoFormList")
    public List<UserInfo> userDataList(){
        return new ArrayList<>();
    }

    /**
     * Formオブジェクトを初期化して返却する
     * @return 検索用Formオブジェクト
     */
    @ModelAttribute("userForm")
    public UserForm clearUserForm(){
        return new UserForm();
    }

    /**
     * 初期表示画面に遷移する
     * @return 検索画面へのパス
     */
    @RequestMapping("/")
    public String index(Model model){
    	UserForm userForm = new UserForm();
    	userForm.setId(null);
    	userForm.setName(null);
    	userForm.setSex(null);
    	userForm.setDob(null);
    	model.addAttribute("userForm",userForm);
        return "top";
    }

    /**
     * 検索画面に遷移する
     * @return 検索画面へのパス
     */
    @RequestMapping("/search")
    public String search(){
        return "search";
    }

    /**
     * 登録画面に遷移する
     * @return 登録画面へのパス
     */
    @RequestMapping("/register")
    public String register(){
    	return "register";
    }

    /**
     * 登録確認画面に遷移する
     * @return 登録画面へのパス
     */
    @RequestMapping("/confirm")
    public String confirm(){
        return "confirm";
    }

    /**
     * 検索処理を行い、一覧画面に遷移する
     * @param searchForm 検索用Formオブジェクト
     * @param model Modelオブジェクト
     * @param result バインド結果
     * @return 一覧画面へのパス
     */
    @RequestMapping("/search_result")
    public String searchResult(UserForm userForm, Model model, BindingResult result){
        //検索用Formオブジェクトのチェック処理
        //ユーザー情報リストを取得
        List<UserForm> demoFormList = demoService.demoFormList(userForm);
        //ユーザー情報リストを更新
        model.addAttribute("demoFormList", demoFormList);
        return "search_result";
    }

    /**
     * 確認画面に遷移する
     * @param demoForm Formオブジェクト
     * @param result バインド結果
     * @return 確認画面または入力画面へのパス
     */
    @PostMapping(value = "/confirm", params = "next")
    public String confirm(@Validated UserForm userForm, BindingResult result){
        //チェック処理を行い、画面遷移する
		if (result.hasErrors()) {
			return "register";
		}
        return "confirm";
    }

    /**
     * 完了画面に遷移する
     * @param demoForm Formオブジェクト
     * @param result バインド結果
     * @return 完了画面
     */
    @PostMapping(value = "/complete", params = "next")
    public String send(UserForm userForm, BindingResult result){
        //追加処理を行う
        demoService.create(userForm);
        return "complete";
    }

}
