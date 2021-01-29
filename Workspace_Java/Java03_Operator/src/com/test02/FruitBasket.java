package com.test02;

public class FruitBasket {
	
	static int basketSize = 20;
	int count = 10;
	String fruitName;
	
	public void basketSetting(String name, int fruit) {
		fruitName = name;
		// 1. count라는 전역변수에, 파라미터 fruit를 통해 전달된 값을 "추가"하자.
		count = fruit;
		basketPrn();
	}
	
	private void basketPrn() {
		System.out.println("바구니 안의 과일 : " + fruitName);
		
		// 2. basketSize가 count보다 크거나 같으면, fruitName + "의 갯수는 " + count + "입니다."
		// 그렇지 않으면 "바구니가 넘쳤습니다." 를 출력!!
		// 삼항연산자 사용하자.
		String result =  (basketSize >= count) ? fruitName+"의 갯수는 "+count+" 입니다." : "바구니가 넘쳤습니다.";
		System.out.println(result);
	}

}
