package salesPath;

public class Solution {
	static class Node {
	   
	    int cost; 
	    Node[] children;
	    Node parent;

	    Node(int cost) {
	      this.cost = cost;
	      children = null;
	      parent = null;
	    }
	}
	
	/*
	 * Time: O(N), N = number of nodes in BT, since we explore every single node in the tree
	 * Space: O(H), H = height of BT, since there could be up to H calls on the recursion stack at some given time t
	 * Algorithm: compute the sum of costs in each path and take the minimum
	 */
	static class SalesPath{
		
		int getCheapestCost(Node rootNode) {
			
			if(rootNode == null) { return 0; } 	//return 0 if root is null
			
			int minCost = Integer.MAX_VALUE;	//init min cost to max int value
			
			if(rootNode.children.length == 0) {	// return 0 if curr node has no children (it is a leaf node!)
				return 0;
			}
			
			for(int i = 0; i < rootNode.children.length; i++) {	//recursively apply the algo on all the children of the current node
				int currCost = getCheapestCost(rootNode.children[i]);
				
				minCost = (currCost < minCost) ? currCost : minCost;	//update minCost if we find a better minCost
			}
			
			return minCost + rootNode.cost;	//return sum of (minCost + curr node's cost)
		}
		
	}
	
	public static void main(String[] args) {
		
//		Node rootNode = new Node(0);
//		Node n0 = new Node(0);
//		Node n1 = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
//		Node n5 = new Node(5);
//		Node n6 = new Node(6);
//		Node n10 = new Node(10);
//		Node n8 = new Node(0);
//		
//		rootNode.children = new Node[]{n5, n3, n6};
//		n5.children = new Node[] {n4};
//		n4.children = new Node[] {};
//		
//		n3.children = new Node[] {n2, n0};
//		n2.children = new Node[] {n1};
//		n1.children = new Node[] {n1};
		
		
	}
	
}
