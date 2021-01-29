package com.dto;

public class ScoreDto {

	private int s_no;
	private String s_name;
	private int s_kor;
	private int s_eng;
	private int s_math;
	private int s_sum;
	private double s_avg;
	private String s_grade;

	public ScoreDto() {
	}
	public ScoreDto(int s_no, String s_name, int s_kor, int s_eng, int s_math) {
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
	}
	public ScoreDto(int s_no, String s_name, int s_kor, int s_eng, int s_math, int s_sum, double s_avg,	String s_grade) {
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
		this.s_sum = s_sum;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_kor() {
		return s_kor;
	}
	public void setS_kor(int s_kor) {
		this.s_kor = s_kor;
	}
	public int getS_eng() {
		return s_eng;
	}
	public void setS_eng(int s_eng) {
		this.s_eng = s_eng;
	}
	public int getS_math() {
		return s_math;
	}
	public void setS_math(int s_math) {
		this.s_math = s_math;
	}
	public int getS_sum() {
		return s_sum;
	}
	public void setS_sum(int s_sum) {
		this.s_sum = s_sum;
	}
	public double getS_avg() {
		return s_avg;
	}
	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}
	public String getS_grade() {
		return s_grade;
	}
	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}
	@Override
	public String toString() {
		return "[" + s_no + "] 이름 : " + s_name + " \t 국어 : " + s_kor + " \t 영어 : " + s_eng + " \t 수학 : "
				+ s_math + "\t 총점 : " + s_sum + " \t 평균 : " + String.format("%.2f",s_avg) + " \t 등급 : " + s_grade;
	}
	
}

