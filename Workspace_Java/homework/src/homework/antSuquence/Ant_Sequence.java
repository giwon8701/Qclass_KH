package homework.antSuquence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ant_Sequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("개미수열을 몇 줄 출력하시겠습니까? : ");
		int max = sc.nextInt();
		int max_length = 0;

		String currentLine = "1";

		Ant_method ant = new Ant_method();
		List<String> res = new ArrayList<String>();

		// 입력한 수만큼 개미수열을 생성, res에 개미수열을 담아줌
		for (int i = 0; i < max; i++) {
			res.add(i, currentLine);
			currentLine = ant.getNextLine(currentLine);
		}
		// 가장 긴 개미수열의 길이를 담아줌
		max_length = res.get(max - 1).length();

		// 출력
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max_length / 2 - res.get(i).length() / 2; j++) {
				System.out.print(" ");
			}
			System.out.println(res.get(i));
		}

		sc.close();
	}
}