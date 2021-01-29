package com.dto;

public class MemberDto {

	private int m_no;
	private String m_name;
	private int m_age;
	private String m_gender;
	private String m_location;
	private String m_job;
	private String m_tel;
	private String m_email;
	
	// constructor
	public MemberDto() {}
	public MemberDto(int m_no, String m_name, int m_age, String m_gender) {
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_gender = m_gender;
	}
	public MemberDto(int m_no, String m_name, int m_age, String m_gender, String m_location, String m_job, String m_tel, String m_email) {
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_gender = m_gender;
		this.m_location = m_location;
		this.m_job = m_job;
		this.m_tel = m_tel;
		this.m_email = m_email;
	}
	
	// getter & setter
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_age() {
		return m_age;
	}
	public void setM_age(int m_age) {
		this.m_age = m_age;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public String getM_location() {
		return m_location;
	}
	public void setM_location(String m_location) {
		this.m_location = m_location;
	}
	public String getM_job() {
		return m_job;
	}
	public void setM_job(String m_job) {
		this.m_job = m_job;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	

	// toString
	@Override
	public String toString() {
		return "M_NO=" + m_no + ", M_NAME=" + m_name + ", M_AGE=" + m_age + ", M_GENDER=" + m_gender
				+ ", M_LOCATION=" + m_location + ", M_JOB=" + m_job + ", M_TEL=" + m_tel + ", M_EMAIL=" + m_email;
	}
	
}