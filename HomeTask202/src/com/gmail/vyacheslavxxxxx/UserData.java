package com.gmail.vyacheslavxxxxx;

 
import java.util.HashMap;
import java.util.Map;

public class UserData {
	private HashMap<String, String> userDatas;

	public HashMap<String, String> getUserDatas() {
		return userDatas;
	}

	public void setUserDatas(HashMap<String, String> userDatas) {
		this.userDatas = userDatas;
	}

	public String getTextDataBiggerSix() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, String> userData : userDatas.entrySet()) {
			if (userData.getValue().length() > 6) {
				String key = userData.getKey();
				String value = userData.getValue();
				System.out.println(key + " " + value);
				result.append(key).append(" ").append(value).append(System.lineSeparator());
			}
		}
		return result.toString();
	}
}
