package arrayOfArrayProducts;

import java.util.Arrays;

public class Solution {
	
	/*
	 * Time: O(N), N = size of input array arr
	 * Space: O(N), created two array to store left and right products
	 * Algorithm: compute cumulative left and right products, result[i] = left[i]*right[i]
	 */
	
	public static int[] arrayOfArrayProducts(int[] arr) {
		
		if(arr.length <= 1) {	//base case, return empty array if input is of size less than 2
			return new int[] {};
		}
		
		final int LEN = arr.length;
		
		int[] left_prod = new int[LEN], right_prod = new int[LEN];	//init left and right prod arrays
		
		left_prod[0] = 1;	//set lest-most el in left = 1 and right-most el in right = 1
		right_prod[LEN-1] = 1;
		
		for(int i = 1; i < LEN; i++) {	//iterate over LEN
			left_prod[i] = left_prod[i-1] * arr[i-1]; //compute cumulative left
			right_prod[LEN-i-1] = right_prod[LEN-i] * arr[LEN-i];	//compute cumulative right
		}
		
		for(int i = 0; i < LEN; i++) {
			arr[i] = left_prod[i] * right_prod[i];	//overwrite arr with result values
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayOfArrayProducts(new int[] {8, 10, 2})));
		System.out.println(Arrays.toString(arrayOfArrayProducts(new int[] {2, 7, 3, 4})));
	}
	
}
