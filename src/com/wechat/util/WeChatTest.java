package com.wechat.util;

import java.io.IOException;

import org.apache.http.ParseException;

import com.wechat.po.AccessToken;

public class WeChatTest {

	public static void main(String[] args) {
		String result;
		try {
			AccessToken token = WeChatUtil.getAccessToken();
			System.out.println("票据"+token.getToken());
			System.out.println("有效时间"+token.getExpiresIn());
			result = WeChatUtil.translate("my name is laobi");
			System.out.println(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
