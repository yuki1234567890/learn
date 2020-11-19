package com.example.demo.form;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserForm {


		/** 検索用ＩＤ */
		private String id;

		/** 検索用名前 */
		private String name;

		/** 検索用性別 */
		private String sex;



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
}
