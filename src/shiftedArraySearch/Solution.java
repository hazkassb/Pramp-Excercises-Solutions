package shiftedArraySearch;

public class Solution {
	
	
	//BRUTE FORCE:
	/*
	 * Space Complexity: O(1), no extra space used
	 * Time Complexity: O(n), n = length of shiftArr
	 */
	public static int shiftArrSearch1(int[] shiftArr, int num) {
		for(int i = 0; i < shiftArr.length; i++) {
			if(shiftArr[i] == num) return i;
		}
		
		return -1;
	}
	
	
	//OPTIMAL SOLUTION
	/*
	 * implementation of method shiftArraySearch
	 * Time: O(logN), N = size of shiftArr
	 * Space: O(1), no additional space used, only constant space
	 */
	public static int shiftArrSearch2(int[] shiftArr, int num) {
		int pivotIndex = getPivotIndex(shiftArr);
		
		if(pivotIndex == 0 ||  shiftArr[0] > num) {
			return binarySearch(shiftArr, pivotIndex, shiftArr.length-1, num);
		}
			
		return binarySearch(shiftArr, 0, pivotIndex-1, num);
	}
	
	/*
	 * A method to find the pivot point in shiftArray
	 * Space: O(1), no additional space used, only constant variables created.
	 * Time: O(logN), N = size of shiftArr
	 */
	private static int getPivotIndex(int[] arr) {
		int left = 0, right = arr.length-1;
		
		if(arr[0] < arr[right]) {
			return 0;
		}
		
		while(left <= right) {
			int mid = left + ((right-left)/2);
			
			if(mid-1 >= 0 && arr[mid-1] > arr[mid]) {
				return mid;
			} else if(arr[mid] > arr[arr.length-1]) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		
		return -1;
	}
	
	/*
	 * A method to find the index of num in shiftArray
	 * 	Time: O(logN), N = number of elements in shiftArr
	 * 	 Space: O(1), no additional space used
	 */
	private static int binarySearch(int[] arr, int start, int end, int num) {
		while(start <= end) {
			int mid = start + ((end-start)/2);
			
			if(arr[mid] == num) {
				return mid;
			} else if(arr[mid] < num) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] shiftArr = new int[] {9, 12, 17, 2, 4, 5};
		System.out.println(shiftArrSearch2(shiftArr, 2));
	}
	
	
}
