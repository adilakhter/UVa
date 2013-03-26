import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;


public class DutchNationalFlagProblem {

	// a contain 1,2, 0 
	// 0 --> red
	// 1 --> blue 
	// 2 --> white 
	public static int[] sort(int [] a){

		int mid, low, high; 
		mid = low = 0; 
		high = a.length-1; 
		
		
		while (mid <= high){
			if (a[mid] <= -1 ){
				swap(a, low, mid);
				low++;
				mid++;
			}
			else if ( a[mid] == 0 )
				mid++; // doing nothing  as it is the mid partition
			else {
				swap(a, mid, high);
				high--;
				// swaping high with mid. In the next iteration, it is the swaped value is checked 
				// hence, mid does not get incremented 
				
			}
		}
		return a; 
	}
	
	public static void swap( int[] a , int i , int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] =temp;
	}
	
	
	
	@Test
	public void testDutchFlagProblem_BaseCase() {
		int [] testInput = {2,1,0};
		
		int [] actuals = sort(testInput);
			
		int [] expecteds = {0,1,2};
		
		assertArrayEquals(expecteds, actuals);
		
	}
	
	
	@Test
	public void testDutchFlagProblem_ContainsDuplicates() {
		int [] testInput = {1,1,0,-1,-1,1,1};
		
		int [] actuals = sort(testInput);
			
		int [] expecteds = {-1,-1,0,1,1,1,1};
		
		assertArrayEquals(expecteds, actuals);
		
	}
}
