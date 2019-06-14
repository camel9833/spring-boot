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
		String json = "";
		String url = "https://jsonplaceholder.typicode.com/posts";

		// ---------------------------------------------------------
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
					         .addHeader("Authorization", "TEST AUTH")
					         .url(url)
					         .build();
			Response response = client.newCall(request).execute();
			String result = response.body().string();
			
			// string --> list
			Gson gson = new Gson();
			List<TestVO> info = Arrays.asList(gson.fromJson(result, TestVO[].class));

			// list -> string
			json = gson.toJson(info);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ---------------------------------------------------------

		return json;

	}

}
