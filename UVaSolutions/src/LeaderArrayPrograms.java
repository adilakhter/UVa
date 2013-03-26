import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

// Write a program to print all the LEADERS in the array. 
// An element is leader if it is greater than all the elements to its right side. 
// And the rightmost element is always a leader. 
// For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
public class LeaderArrayPrograms {

	public int[] computeLeaders(int[] a){
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		
		int tempLeader = -1;
		
		for(int i =  (a.length -1); i>=0; i--){
			if ( a[i] > tempLeader){
				leaders.add(a[i]);
				tempLeader = a[i];
			}
		}
		
		return toArray(leaders);
	}
	
	
	public int[] toArray(ArrayList<Integer> leaders){
		
		int[] arrtoReturn = new int[leaders.size()];
		int i = arrtoReturn.length -1 ;
		for( int leader:leaders){ 
			arrtoReturn[i] = leader;
			i--;
		}
		return arrtoReturn;
	}
	
	@Test
	public void testNextGreatestElements() {
	
		int[] testArr = {16, 17, 4, 3, 5, 2};
		int[] expecteds = {17, 5 , 2};
		int[] actuals = this.computeLeaders(testArr);
	
		assertArrayEquals(expecteds, actuals);
	}

}
