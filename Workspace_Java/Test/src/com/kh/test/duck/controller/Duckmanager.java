package com.kh.test.duck.controller;

import com.kh.test.duck.model.vo.Duck;
import com.kh.test.duck.model.vo.RubberDuck;

public class Duckmanager {

	public static void main(String[] args) {
		
		Duck[] duck = new Duck[5];
		
		duck[0] = new RubberDuck("도날드", "러버덕", 100);
		
	}
}
