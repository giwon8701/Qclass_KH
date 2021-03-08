package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if (command.equals("view")) {
			response.sendRedirect("view.html");
		} else if (command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if (dao.delete()) {
				System.out.println("db 초기화 성공");
			} else {
				System.out.println("db 초기화 실패");
			}
			
			String data = request.getParameter("mydata");
			// JsonElement는 JsonObject, JsonPrimitive, JsonArray, JsonNull 이 4가지의 부모 클래스로 추상클래스로 정의된다.
			JsonElement element = JsonParser.parseString(data);	// mydata를  넣어둠
			JsonObject jsonData = element.getAsJsonObject();	// JsonObject로 변환함(결과물 : jsonData)
			
			JsonElement records = jsonData.get("records");	// jsonData에서 records인 키값의 value를 가져옴
			JsonArray recordsArray = records.getAsJsonArray();	// value값들은 array형식으로 가져옴
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			for (int i=0; i<recordsArray.size(); i++) {
				// recordsArraydp 담아놓은 value값(k:v로 이루어진 value)중 "자전거대여소명"이라는
				// key의 value값을 string으로 가져옴
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				if (recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson();
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			System.out.println(resultArray);
			if (dao.insert(list)) {
				System.out.println("db 저장 성공");
			} else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			
			response.getWriter().append(result+"");
		}
		
	}

}
