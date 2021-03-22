package arrayQuadruplet;

import java.util.Arrays;

public class Solution {
	
	/*
	 * Time: O(N^3), N = size of arr
	 * Space: O(4) ~ O(1)
	 * Algorithm: sort the arr, pin two values in arr, find the complement of the sum of those two values
	 * in the sub-array starting one index after the latest value. if the complement exist, return result array
	 *  else, return empty array
	 */
	public static int[] findArrayQuadruplet(int[] arr, int s) {
		if(arr.length < 4) {
			return new int[] {};
		}
		
		final int LEN = arr.length;
		
		Arrays.sort(arr);	//O(NlogN)
		
		for(int i = 0; i <= LEN-4; i++) {	//O(N^3)
			for(int j = i+1; j <= LEN-3; j++) {
				int remainder = s - (arr[i]+arr[j]);
				int low = j+1, high = LEN-1;
				
				while(low < high) {
					if(arr[low] + arr[high] < remainder) {
						low++;
					} else if(arr[low] + arr[high] > remainder) {
						high--;
					} else {
						return new int[] {arr[i], arr[j], arr[low], arr[high]};
					}
				}
			}
		}
		
		return new int[] {};
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findArrayQuadruplet(new int[] {2, 7, 4, 0, 9, 5, 1, 3}, 20)));
	}
	
}
