import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위 바위 보 게임을 시작합니다.");
		// draw라는 전역변수에 비겼는지 저장
		boolean draw = false;
		
		do {
			System.out.println("가위 바위 보 중 한 개를 입력하세요 : ");
			String input = sc.nextLine();
			
			System.out.println("당신은 " + input + "를 냈습니다.");
			
			// random() * 4 -> random() * 3  // 0~3에서 0~2으로 고침
			int random = (int)(Math.random() * 3);
			String computer = "";
			
			switch(random) {
			case 0 : computer = "가위"; break;
			case 1 : computer = "바위"; break;
			case 2 : computer = "보"; break;
			}
			
			System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
			
			// ==은 주소값비교이므로 값비교인 .equals()로 전부 바꿔줌
			if(computer.equals(input)) {
				System.out.println("비겼습니다. 다시 시작합니다");
				draw = true;
			} else {
				boolean win = false;
				draw = false;
				if (computer.equals("가위")) {
					if(input.equals("바위")) {
						win = true;
					}
				} else if(computer.equals("바위")) {
					if(input.equals("보")) {
						win = true;
					}
				} else {
					if (input.equals("가위")) {
						win = true;
					}
				}
				
				if (win) {
					System.out.println("당신이 이겼습니다!");
					break;
				} else {
					System.out.println("당신이 졌습니다!");
					break;
				}
			}
		} while(draw);
	}
}
