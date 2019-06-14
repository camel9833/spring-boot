package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.TestVO;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@RestController
public class TestController {
	@RequestMapping("/test")
	public String getTest() {
//		return "{\"result\":true,\"resultMsg\":\"성공입니다.\"}";
		String url = "https://jsonplaceholder.typicode.com/posts";
//		String jsonString = get(uri);
//		System.out.println(jsonData);

	//---------------------------------------------------------
		  try {
			    OkHttpClient client = new OkHttpClient();

//			    String url = SERVER_CONFIGURATION.ADDRESS + ":" +
//			        SERVER_CONFIGURATION.PORT + "/v1/userinfo";

			    Request request = new Request.Builder()
			        .addHeader("Authorization", "TEST AUTH")
			        .url(url)
			        .build();
			    Response response = client.newCall(request)
			        .execute();

			    String result = response.body().string();
			    
//			    System.out.println(result);

			    Gson gson = new Gson();
			    List<TestVO> info = Arrays.asList(gson.fromJson(result, TestVO[].class));

			    System.out.println(info.get(0).getId());
//			    Log.i("id: " + info.id);
//			    Log.i("name: " + info.name);

//			    return true;
			  } catch(Exception e) {
			    e.printStackTrace();
			  }
		
		
		
	//---------------------------------------------------------
		
	return "111";

	}

/*	
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
*/
	
}
