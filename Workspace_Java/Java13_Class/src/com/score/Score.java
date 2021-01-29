package com.score;

public class Score {

	// field
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	// constructor
	public Score() {
		
	}
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	// getSum, getAvg, getGrade
	public int getSum() {
		return kor + eng + math;
	}
	
	public double getAvg() {
		return (double)getSum()/3;
	}
	
	public String getGrade() {
		String grade = null;
		// 100 ~ 90 : A, 80 ~ 89 : B, 70 ~ 79 : C, 60 ~ 69 : D, 0 ~ 59 : F
		switch((int)getAvg() / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		
		return grade;
	}
	/*
	@Override
	public String toString() {
		return "이름 : " + name + " 국어 : " + " 영어 : " + eng + " 수학 : " + math + "\n총점 : " + getSum() + " 평균 : " + getAvg() + " 등급 : " + getGrade();
	}
	*/
}
