package bracketMatch;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	/*
	 * Time: O(N), N = length of String text
	 * Space: O(N), N = length of String text
	 * 
	 * Algorithm: count unmatched closing brackets and store opening brackets in a stack,
	 * pop() the stack when we find a matching bracket, in the end we return size of stack + number of unmatched closings
	 */
	public static int bracketMatch(String text) {
		Deque<Character> stack = new ArrayDeque<>();
		
		int count = 0;	//count unmatched closing brackets
		
		for(char ch : text.toCharArray()) {
			if(ch == '(') {	//if (, push onto stack
				stack.push(ch);
			} else {	//else:
				if(!stack.isEmpty()) { //if stack is not empty
					stack.pop(); //pop() stack and continue
					continue;
				}
				count++;	//else, increment count and continue looping
			}
		}
		
		return count + stack.size();
	}
	
	
	public static void main(String[] args) {
		System.out.println(bracketMatch("))()(((()"));
	}
}
