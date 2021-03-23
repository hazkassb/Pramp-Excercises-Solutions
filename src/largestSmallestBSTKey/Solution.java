package largestSmallestBSTKey;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	static class Node {
	    int key;
	    Node left;
	    Node right; 
	    Node parent;
	    
	    Node(int key) {
	      this.key = key;
	      left = null;
	      right = null;
	      parent = null;
	    }
	  }
	
	static class BinarySearchTree {
	
		static Node root;
		
		//BRUTE FORCE:
		/*
		 * Time: O(N), N = number of nodes in the tree
		 * Space: O(N), N = number of nodes in tree
		 * Algorithm: do an in-order traversal of the tree and store all node values in a list,
		 * traverse the list and return the greatest value less than num;
		 */
		static int findLargestSmallestKey1(int num) {
			if(root == null) {
				return -1;
			}
			
			List<Integer> list = new ArrayList<>();
			
			inOrder(root, list);
			
			for(int i = 1; i < list.size(); i++) {
				if(list.get(i) >= num) {
					return list.get(i-1).intValue();
				}
			}
			
			return list.get(0) < num ? list.get(0).intValue() : -1;
		}
		
		private static void inOrder(Node root, List<Integer> list) {
			if(root != null) {
				if(root.left != null) {
					inOrder(root.left, list);
				}
				
				list.add(root.key);
				
				if(root.right != null) {
					inOrder(root.right, list);
				}
			}
		}
		
		
		//OPTIMAL SOLUTION
		/*	Time: O(logN) if the tree is balanced, N = number of nodes in the tree
		 * 	Space: O(1), we use only constant space
		 * 	Algorithm: Traverse the tree from the root to a leaf node taking advantage of the 
		 * 	binary nature of the tree. The root.key is less than num, update result and search right, else, search left
		 */
		static int findLargestSmallestKey2(int num) {
			int result = -1;
			
			while(root != null) {
				if(root.key < num) {
					result = root.key;
					root = root.right;
				} else {
					root = root.left;
				}
			}
			
			return result;
		}
		
		
		
		
		
		
	    //  inserts a new node with the given number in the
	    //  correct place in the tree
	    void insert(int key) {
		      // 1) If the tree is empty, create the root
		      if(this.root == null) {
		        this.root = new Node(key);
		        return;
		      }
		      
		      // 2) Otherwise, create a node with the key
		      //    and traverse down the tree to find where to
		      //    to insert the new node
		      Node currentNode = this.root;
		      Node newNode = new Node(key); 
		      
		      while(currentNode != null) {
		        if(key < currentNode.key) {
		          if(currentNode.left == null) {
		            currentNode.left = newNode;
		            newNode.parent = currentNode;
		            break;
		          } else {
		            currentNode = currentNode.left;
		          }
		        } else {
		          if(currentNode.right == null) {
		            currentNode.right = newNode;
		            newNode.parent = currentNode;
		            break;
		          } else {
		            currentNode = currentNode.right;
		          }
		        }
		      }
	    }
	    
	}


	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
	     bst.insert(20);
	     bst.insert(9);
	     bst.insert(25);
	     bst.insert(5);
	     bst.insert(12);
	     bst.insert(11);
	     bst.insert(14);
	     
	     int result1 = BinarySearchTree.findLargestSmallestKey1(17);
	     int result2 = BinarySearchTree.findLargestSmallestKey2(17);

	     System.out.println("1. Largest smaller number is " + result1);
	     System.out.println("2. Largest smaller number is " + result2);


	}

}
