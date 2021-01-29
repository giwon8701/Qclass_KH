package com.test01;

import java.util.Arrays;

public class ShallowCopy {
	
	// 새로운 객체 생성
	// 얕은 값 복사 (주소값 복사) (shallow copy
	public static void main(String[] args) {
		
		int[] original = {10, 20, 30, 40, 50};
		int[] copy = original;
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		System.out.println(original);
		System.out.println(copy);
		
		copy[2] = 300;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
	}

}
