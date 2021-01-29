package com.kh;

public class Sugar extends Product {

	private String type;
	private int weight;
	
	public Sugar() {
		
	}
	public Sugar(int productCode, String productName, String type, int weight) {
		super(productCode, productName);
		this.type = type;
		this.weight = weight;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public void makeProduct() {
		System.out.println(super.toString() + ", 제품유형 : " + type + ", 중량 : " + weight + "kg 설탕을 생산하였습니다.");
	}
	
	
}
