package com.qijiabin.test;

import com.qijiabin.entity.AccessToken;
import com.qijiabin.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * ========================================================
 * 日 期：2016年9月26日 下午3:07:39
 * 版 本：1.0.0
 * 类说明：
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class Test {
	
	private String token;

	/**
	 * 获取access_token
	 */
	@org.junit.Before
	public void testGetAccessToken() {
		AccessToken accessToken = WeixinUtil.getAccessToken("***", "***");
		if (accessToken != null) {
			System.out.println(accessToken.getToken());
			this.token = accessToken.getToken();
		}
	}
	
	/**
	 * 获取公众号已创建的标签
	 */
	@org.junit.Test
	public void testGetTags() {
		JSONObject jsonObject = WeixinUtil.httpRequest(WeixinUtil.tags_url.replace("ACCESS_TOKEN", this.token), "GET", null);
		System.out.println(jsonObject);
	}
	
	/**
	 * 获取用户列表
	 */
	@org.junit.Test
	public void testGetUserList() {
		String requestUrl = WeixinUtil.user_url.replace("ACCESS_TOKEN", this.token).replace("NEXT_OPENID", "");
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		System.out.println(jsonObject);
	}
	
	/**
	 * 获取微信服务器IP地址
	 */
	@org.junit.Test
	public void testGetIps() {
		JSONObject jsonObject = WeixinUtil.httpRequest(WeixinUtil.ips_url.replace("ACCESS_TOKEN", this.token), "GET", null);
		System.out.println(jsonObject);
	}
	
	/**
	 * 根据openid来群发消息  
	 */
	@org.junit.Test
	public void testSendMsg() {
		String openid1data = "{\"touser\":[\"o1b5dxK1g3fmccuDIhCfKmaKIG_U\",\"o1b5dxK1g3fmccuDIhCfKmaKIG_U\"],\"msgtype\": \"text\",\"text\": {\"content\": \"测试文本消息\"}}"; 
		JSONObject jsonObject = WeixinUtil.httpRequest(WeixinUtil.send_url.replace("ACCESS_TOKEN", this.token), "GET", openid1data);
		System.out.println(jsonObject);
	}
	
}

