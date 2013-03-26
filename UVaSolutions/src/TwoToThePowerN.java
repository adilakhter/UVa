import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

// given an integer N, not exceeding 10000
// output 2^N

public class TwoToThePowerN {

	public String computeTwoPowerN(int n){
		final int maxallowedDigit = 2;
		int[] digits = new int [maxallowedDigit];
		
		digits[maxallowedDigit-1] = 1;
		
		for (int i =0; i< n; ++i){
			int p = 0; 
			
			for (int j = (maxallowedDigit-1); j >= 0; --j){
				int r = p + 2*digits[j];
				p = 0;
				while (r >= 10){
					p +=1; 
					r -=10;
				}
				digits[j] = r;
			}
		}
		
		String s = "";
		
		for ( int i = 0 ; i< maxallowedDigit; ++i){
			if (s.length() > 0 || digits[i]>0){
				s += digits[i];
			}
		}
		
		return s;
	}
	
	
	@Test
	public void testNextGreatestElements() {
		
		int toTest = 5;
		
		String actual = computeTwoPowerN(toTest);
		String expected = "32";
		
		assertEquals(expected, actual);
		
	}

}
