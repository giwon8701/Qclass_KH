package com.lotto;

public class Lotto {

	private int[] make() {
		int[] arr = new int[6];
		
		/*
		int index = 0;
		while (index < 6) {
			int insert = (int)(Math.random()*45) + 1;

			
			if (isSame(arr, insert)) {
				arr[index] = insert;
				index++;
			}
			
		}
		*/
		for (int index=0; index<6; index++) {
			int insert = (int)(Math.random()*45) + 1;

			
			if (isSame(arr, insert)) {
				System.out.println("출력: "+insert);
				arr[index] = insert;
			} else {
				index--;
			}
		}

		
		return arr;
	}
	
	// 1 ~ 45 사이의 "중복 없는" 랜덤한 숫자 6개
	public boolean isSame(int[] arr, int insert) {
		boolean same = true;
		
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == insert) {
				same = false;
				break;
			}
		}
		return same;
	}
	
	// 정렬
	private void sort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=1; j<arr.length; j++) {
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
	
	public void prn() {
		int[] arr = make();
//		System.out.println(Arrays.toString(arr));
		sort(arr);
		
		System.out.print("{");
		for (int i=0; i<arr.length; i++) {
			System.out.printf("%3d", arr[i]);
		}
		System.out.println("}");
	}
	
}
