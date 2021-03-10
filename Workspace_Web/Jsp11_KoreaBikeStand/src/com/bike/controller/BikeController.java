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
				System.out.println("db �ʱ�ȭ ����");
			} else {
				System.out.println("db �ʱ�ȭ ����");
			}
			
			String data = request.getParameter("mydata");		// json������ ���ڿ��� json ��ü�� ��ȯ (string -> json object)
			// JsonElement : JsonObject, JsonArray, JsonPrimitive, JsonNull ������ ��� ����
			JsonElement element = JsonParser.parseString(data);	// json������ ���ڿ��� json ��ü�� ��ȯ (string -> json object)
			// JsonObject : key-value pair ({String : JsonElement} ����)
			JsonObject jsonData = element.getAsJsonObject();	// JsonElement�� JsonObject, JsonPrimitive, JsonArray, JsonNull �� 4������ �θ� Ŭ������ �߻�Ŭ������ ���ǵȴ�
			
			// records�� �ش��ϴ� ������ ����
			JsonElement records = jsonData.get("records");	// bike.json���� �����´�
			JsonArray recordsArray = records.getAsJsonArray();	
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			for (int i=0; i<recordsArray.size(); i++) {
				/*
				 JsonElement tempElement = resordsArray.get(i);
				 JsonObject tempObject = tempElement.getAsJsonObject();
				 JsonElement nameElement = tempObject.get("�����Ŵ뿩�Ҹ�");
				 String name = nameElement.getAsString();
				 */
				String name = recordsArray.get(i).getAsJsonObject().get("�����Ŵ뿩�Ҹ�").getAsString();
				String addr = null;
				if (recordsArray.get(i).getAsJsonObject().get("���������θ��ּ�") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("���������θ��ּ�").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("�����������ּ�").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("����").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("�浵").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("�����ź������").getAsInt();
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson();
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			System.out.println(resultArray);
			if (dao.insert(list)) {
				System.out.println("db ���� ����");
			} else {
				System.out.println("db ���� ����");
			}
			
			JsonObject result = new JsonObject();		// ���̽� ��ü ����
			result.add("result", resultArray);			// String ���� result�� �־���
			
			response.getWriter().append(result+"");		// html�� ����
		}
		
	}

}
