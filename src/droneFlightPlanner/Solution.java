package droneFlightPlanner;

public class Solution {
	
	/*
	 * 	Time Complexity = O(N), where N = length of route
	 * 
	 * 	Space Complexity = O(1) since I am using any extra space
	 */
	
	/*
	 * The drone online expends or gains energy by going up or down, 
	 * therefore we need only consider the z coordinate.
	 * 
	 */
	public static int calcDroneMinEnergy(int[][] route) {
		int max = route[0][2];
		
		for(int i = 1; i < route.length; i++) {
			max = route[i][2] > max ? route[i][2] : max;
		}
		
		
		return max - route[0][2];
	}
	
	
	
	public static void main(String[] args) {
		int[][] route = { {0,   2, 10},
		                  {3,   5,  0},
		                  {9,  20,  6},
		                  {10, 12, 15},
		                  {10, 10,  8} };
		
		System.out.println(calcDroneMinEnergy(route));
	}
}
