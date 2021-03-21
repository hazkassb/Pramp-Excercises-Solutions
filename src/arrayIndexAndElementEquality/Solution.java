package arrayIndexAndElementEquality;

public class Solution {
	
	//BRUTE FORCE
	/*
	 * Time: O(N), N = size of arr
	 * Space: O(1), no extra space used, only constant variables are used
	 * Algorithm: linear scan of arr
	 */
	public static int indexEqualsValueSearch1(int[] arr) {
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == i) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	//OPTIMIZED SOLUTION
	
	/*
	 * Time: O(logN), N = size of arr
	 * Space: O(1), no extra space is used, only constant variables are declared
	 * Algorithm: binary search on arr
	 */
	public static int indexEqualsValueSearch2(int[] arr) {
		int left= 0, right = arr.length-1;
		
		while(left <= right) {
			int mid = left + ((right-left)/2);
			
			if(arr[mid] == mid) {
				return mid;
			} else if(arr[mid] < mid) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		return -1;
	}

	
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{-1, 0, 3, 6};
		int[] arr2 = new int[]{-8, 0, 2, 5};
		
		System.out.println(indexEqualsValueSearch2(arr1));
		System.out.println(indexEqualsValueSearch2(arr2));
	}
}
