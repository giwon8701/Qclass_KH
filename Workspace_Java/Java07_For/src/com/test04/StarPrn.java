package com.test04;

public class StarPrn {

	
	/*
	 * ★
	 * ★★
	 * ★★★
	 * ★★★★
	 * ★★★★★
	 */
	public void prn01() {
		for (int i=1; i<=5; i++) {
			for (int cnt=0; cnt<i; cnt++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*
	 * ★★★★★
	 * ★★★★
	 * ★★★
	 * ★★
	 * ★
	 */
	public void prn02() {
		for (int i=5; i>0; i--) {
			for (int cnt=0; cnt<i; cnt++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*
	 *     ★
	 *    ★★
	 *	 ★★★
	 *  ★★★★
	 * ★★★★★
	 */
	public void prn03() {
		for (int i=1; i<=5; i++) {
			for (int cnt=1; cnt<=5-i; cnt++) {
				System.out.print(" ");
			}
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*
	 * ★★★★★
	 *  ★★★★
	 *   ★★★
	 *    ★★
	 *     ★
	 */
	public void prn04() {
		for (int i=5; i>0; i--) {
			for (int cnt=1; cnt<=5-i; cnt++) {
				System.out.print(" ");
			}
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	/*
	 *      ★
	 *     ★★★
	 *    ★★★★★
	 *   ★★★★★★★
	 *  ★★★★★★★★★
	 */
	public void prn05() {
		for (int i=1; i<=5; i++) {
			for (int cnt=1; cnt<=5-i; cnt++) {
				System.out.print(" ");
			}
			for (int j=0; j<i-1; j++) {
				System.out.print("*");
			}
			System.out.print("*");
			for (int j=0; j<i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
