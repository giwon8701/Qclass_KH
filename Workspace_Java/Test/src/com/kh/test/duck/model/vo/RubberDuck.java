package com.kh.test.duck.model.vo;

public class RubberDuck extends Duck {

	public static String PLACE = "석촌호수";
	private int weight;
	
	public RubberDuck() {}
	public RubberDuck(String name, String kinds, int weight) {
		setName(name);
		setKinds(kinds);
		this.weight = weight;
	}
	
	// + setter/getter
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight(int weight) {
		return weight;
	}
	
	public void quack() {
		System.out.println(toString() + " 몸무게는 " + weight + "kg입니다. 하지만 전 말을 하지 못해요.");
	}
}
