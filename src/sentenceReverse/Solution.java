package sentenceReverse;

import java.util.Arrays;

public class Solution {
		/* Time: O(N*M), N = size of arr, M = length of shortest word in arr since we are calling rev method on each word
		 * Space: O(1), no extra space is used, reversing is done in-place
		 * Algorithm: reverse the whole input array, then reverse the words inside the array (in-place)
		 */
	
	static char[] reverseStr(char[] arr) {
		rev(arr, 0, arr.length-1);	//reverse the whole array
	    
	    int word_start = -1;	//initialize an index pointer to mark where a word starts
	    
	    for(int i = 0; i < arr.length; i++){	//loop over arr and reverse each word
	      if(arr[i] == ' '){
	        if(word_start != -1){
	        	rev(arr, word_start, i-1);
	        	word_start = -1;
	        }
	      } else if(i == arr.length - 1){
	    	  if(word_start != -1){
	    		  rev(arr, word_start, i);
	    	  }
	      } else{
		        if(word_start == -1){
		        	word_start = i;
		        }
	      }
	    }
	    
	    return arr;
	  }
	
	/*
	 * This reverses the array arr in-place from index start to index end
	 */
	  static void rev(char[] arr, int start, int end){
	    char temp = ' ';
	    
	    while(start < end){
	      temp = arr[start];
	      arr[start] = arr[end];
	      arr[end] = temp;
	      start++;
	      end--;
	    }
	  }
	  
	  
	  public static void main(String[] args) {
		  char[] arr = new char[] {
				  'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', 
		  };
		System.out.println(Arrays.toString(reverseStr(arr)));
	}

}
