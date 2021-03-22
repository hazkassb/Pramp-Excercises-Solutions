package timePlanner;

import java.util.Arrays;

public class Solution {
	//BRTURE FORCE SINCE THE CONSTRAINTS OUTLINES THAT THE MAX SIZE OF THE INPUT ARRAYS IS 100 for each ==> a total of 10000 iterations in worst case
	/*	
	 * Time: O(M*N), M = size of array slotsA, N = size of array slotsB
	 * Space: O(1), no addition space used, only constant variable are defined
	 * Algorithm: iterate over the two arrays, look for a start time that works for both,
	 *  then check if the corresponding time slots can accommodate a meeting that lasts for "dur" units of time
	 */
	public static int[] meetingPlanner1(int[][] slotsA, int[][] slotsB, int dur) {
		
		for(int i = 0; i < slotsA.length; i++) {
			for(int j = 0; j < slotsB.length; j++) {
				int start = Math.max(slotsA[i][0], slotsB[j][0]);
				if(slotsA[i][1] -start >= dur && slotsB[j][1] - start >= dur) {
					return new int[] {start, start+dur};
				}
			}
		}
		
		return new int[] {};
	}
	
	
	//OPTIMIZED SOLUTION
	/* TIME: O(M+N), M = size of slotsA, N = size of slotsB
	 * SPACE: O(1), No extra space used, only constant variables are declared
	 * Algorithm: since the arrays are sorted by slots start time, we use to indices, one for each array. 
	 * if there is a min overlap period of dur between to given times slots, we return the pair [start, start+dur],
	 * else, increment the index of the array with the earlier time slot.
	 */
	
	public static int[] meetingPlanner2(int[][] slotsA, int[][] slotsB, int dur) {
		int ia = 0, ib = 0;
		
		while(ia < slotsA.length && ib < slotsB.length) {
			int start = Math.max(slotsA[ia][0], slotsB[ib][0]);
			int end = Math.min(slotsA[ia][1], slotsB[ib][1]);
			
			if(start + dur <= end) {
				return new int[] {start, start+dur};
			}
			
			if(slotsA[ia][1] < slotsB[ib][1]) {
				ia++;
			} else {
				ib++;
			}
		}
		
		return new int[]{};
	}
	
	
	public static void main(String[] args) {
		int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}}, slotsB = {{0, 15}, {60, 70}};
        
//	      System.out.println(Arrays.toString(meetingPlanner2(slotsA, slotsB, 8)));
	      System.out.println(Arrays.toString(meetingPlanner2(slotsA, slotsB, 12)));

	}
}
