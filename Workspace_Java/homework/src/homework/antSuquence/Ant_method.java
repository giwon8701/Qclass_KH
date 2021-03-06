package homework.antSuquence;

public class Ant_method {

	public String getNextLine(String currentLine) {
		// 같은 숫자를 담는 변수
		StringBuilder sameNum = new StringBuilder("");
		StringBuilder nextLine = new StringBuilder("");

		for (int i = 0; i < currentLine.length(); i++) {
			// 문자열의 끝을 감지했을 때 (1,2번에서 이전문자와 같거나 다를경우에 대해서 처리해줬기 때문에 sameNum에 바로 추가해주면 된다>)
			if (i == currentLine.length() - 1) {
				sameNum.append(currentLine.charAt(i)); // sameNum에 현재문자를 추가해주고
				nextLine.append(sameNumCnt(sameNum)); // sameNum을 계산한 값을 nextLine에 추가해준다.
			}
			// 1. 현재문자와 다음문자가 같을 때
			else if (currentLine.charAt(i) == currentLine.charAt(i + 1)) {
				sameNum.append(currentLine.charAt(i)); // sameNum에 현재문자를 추가해준다.
			}
			// 2. 현재문자와 다음문자가 다를 때
			else if (currentLine.charAt(i) != currentLine.charAt(i + 1)) {
				sameNum.append(currentLine.charAt(i)); // sameNum에 현재문자를 추가해주고
				nextLine.append(sameNumCnt(sameNum)); // sameNum을 계산한 값을 nextLine에 추가해준다.
				sameNum.setLength(0); // sameNum 초기화
			}
		}

		return String.valueOf(nextLine);
	}

	// 같은 숫자가 몇개인지 카운트해서 반환해줌 ex) 1111 -> 14
	public String sameNumCnt(StringBuilder sameNum) {
		String res = String.valueOf(sameNum.charAt(0)) + String.valueOf(sameNum.length());

		return res;
	}
}
