package com.example.demo.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {


		/** ＩＤ */
		private String id;

		/** 名前 */
		@NotEmpty(message="名前を入力してください。")
		private String name;

		/** 性別 */
		@NotEmpty(message="性別を選択してください。")
		private String sex;

		/** 生年月日 */
		@NotEmpty(message="生年月日を入力してください。")
		@Size(min=8, max=8, message="生年月日は8文字です。")
		@Pattern(regexp="[0-9]*", message="生年月日は半角数字です。")
		private String dob;

		/** 性別のMapオブジェクト */
	    public Map<String,String> getSexItems(){
	    	Map<String, String> sexMap = new LinkedHashMap<String, String>();
	    	sexMap.put("男", "男");
	    	sexMap.put("女", "女");
	    	return sexMap;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}
}
