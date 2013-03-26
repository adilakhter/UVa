import org.junit.Test;

import static org.junit.Assert.*;

// replaces every element with its next greatest element 
// {16, 17, 4, 3, 5, 2}-> {17, 5, 5, 5, 2, -1}
public class NextGreatestNumberMain{

	public int[] nextGreatestElements( int[] arr){
		int[] retArray = new int[arr.length];
		
		
		int maxfromright = arr[arr.length-1];
		retArray[arr.length-1] = -1;
		
		for ( int j = (arr.length-2); j>=0 ; j--){
			retArray[j] = maxfromright;
			if ( arr[j] > maxfromright)
				maxfromright = arr[j];
		}
		return retArray; 
	}
	
	
	public void printArray(int [] arr){
		
		for ( int i = 0 ; i < arr.length ; i++){
			System.out.println(arr[i] + " ");
		}	
		
	}
	
	@Test
	public void testNextGreatestElements() {
		
		int[] testArr = {16, 17, 4, 3, 5, 2};
		int[] expected = {17, 5, 5, 5, 2, -1};
		int[] actual = nextGreatestElements(testArr);
		
		assertArrayEquals(expected, actual);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
