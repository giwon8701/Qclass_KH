package com.ant;

/*
 * 1
 * 1 1
 * 1 2
 * 1 1 2 1
 * 1 2 2 1 1 1
 * ...
 */
public class AntQuiz {
	public static void main(String[] args) {
		ant(10);
		
		int cnt = 0;						// 몇줄째인지 확인용
		String prev = "1";				
		String next = "";
	}
	
	public static void ant(int line) {
		String next = "";
		String[] ant = new String[10];
		int j = 0;
		
		
		for(int i=0; i<line; i++) {
			if (i > 0) {
				
			}
			
		}
	}
	
		
		/*
		for (int i=0; i<seq; i++) {
			// 처음 숫자를 넣음
//			temp_num.concat(Character.toString(current_num.charAt(i)));
			j = i;
			while (j < current_num.length()) {
				if(current_num.length() == 1) {
					temp_num.concat(Integer.toString(cnt));
					i = j+1;
					j++;
				}
				// 처음숫자와 다음숫자가 같은경우 카운트+1해줌
				else if (current_num.charAt(j+1) == current_num.charAt(j)) {
					cnt++;
					j++;
				}
				// 비교하는 숫자와 다음숫자가 다른 경우 카운트를 다음숫자끝에 넣어줌
				else {
					temp_num.concat(Integer.toString(cnt));
					cnt = 1;
					i = j+1;
				}
			}
			System.out.println(temp_num);
			temp_num = "";
		}
		*/
		
		
		
}
