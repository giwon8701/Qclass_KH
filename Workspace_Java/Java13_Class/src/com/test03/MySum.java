package com.test03;

public class MySum {

	// overloading
	
	public int sum (int i) {
		return i + i;
	}
	
	public int sum (int i, int j) {
		return i + j;
	}
	
	public int sum (int i, int j, int k) {
		return i + j + k;
	}
	
	public double sum (double d, double f) {
		return d + f;
	}
	
	public int sum (double d1, double d2, double d3) {
		return (int)(d1 + d2 + d3);
	}
}
