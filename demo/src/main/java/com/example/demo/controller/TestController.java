package com.example.demo.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@RestController
public class TestController {
	@RequestMapping("/test")
	public String getTest() {
//		return "{\"result\":true,\"resultMsg\":\"성공입니다.\"}";
		String uri = "https://jsonplaceholder.typicode.com/posts";
		String jsonString = get(uri);
//		System.out.println(jsonData);

	//---------------------------------------------------------

	//---------------------------------------------------------
		
	return jsonString;

	}

	public String get(String requestURL) {

		String message = "-1";
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
//					.addHeader("x-api-key", RestTestCommon.API_KEY)
					.url(requestURL).build(); // GET Request

			// 동기 처리시 execute함수 사용
			Response response = client.newCall(request).execute();

			// 출력
			message = response.body().string();
//			System.out.println(message);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return message;
	}

}
