package awardBudgetCut;

import java.util.Arrays;

/*
 * Space Complexity: max(nlogn, cap), n = size of grantsArray and cap = calculated cap
 * Explanation: nlogn comes from sorting the grantsArray and cap comes from the cap number of 
 * iteration needed to break out of the while loop
 * 
 * Space Complexity: O(1) since I am not using any extra space
 */


/*
 * Algorithm: sort the array, iterate over the sorted array, and eliminate satisfied budgets until
 * the newBudget is used up.
 */

public class Solution {
	
	static double findGrantsCap(double[] grantsArray, double newBudget) {
		
		Arrays.sort(grantsArray);	//sort grants array
		
		int curr_size = grantsArray.length, curr_min_index = 0; //initialize current number of requested budgets and index of smallest budget
		
		double cap = 0, curr_min = grantsArray[curr_min_index];	//initialize cap and current minimum requested budget
		
		while(newBudget > curr_size){	//loop over the grants array
			cap++;	//increment cap
			
			newBudget -= curr_size;	//decrement cap by number of unsatisfied requested budgets
			
			if(cap >= curr_min) {	//if current min is satisfied
				curr_min = grantsArray[++curr_min_index];	// then update curr min to next smallest requested budget
				curr_size--;	// decrement current number of requested budgets
			}
		}
		
		if(newBudget > 0 && curr_size > 0) {	// if budget and curr numb of requested budget are both non-zero, then add the ratio to cap
			cap += newBudget/curr_size;
		}
		
		return cap;	//return cap
	}
	
	
	public static void main(String[] args) {
		double[] grantsArray = {2, 100, 50, 120, 1000};
		
		System.out.println(findGrantsCap(grantsArray, 190));
	}

}
