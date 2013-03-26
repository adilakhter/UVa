import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class MaxOccurChar {

		
	public static 	List<Character>  getMaxCharacters(int[] counters){
		int max =0 ;
		List<Character> maxChars = new ArrayList<Character>();
		
		// keeping only those characters that have max counters 
		for (int j = 0; j< counters.length; j++){
			if (max == counters[j]){
				maxChars.add((char)j);
			}
			else 
				if (max < counters[j]){
					maxChars.clear();
					max = counters[j];
					maxChars.add((char)j);
				}
		}
		
		return maxChars;
		
	}
	
	public static List<Character> maxChar(String s){
		char chars[] = s.toCharArray();
		int intA[] = new int[256];
		
		// initializing array of 256 ASCII  characters 
		for(int i=0; i<intA.length ; i++) intA[i] =0;
	
		// keeping a counter for each character and increasing
		// them upon encountering characters.  
		for(char c : chars){
			int x = c;
			intA[x]++;
		}
		
		// returning a list of characters with max counters 
		return getMaxCharacters(intA);
	}
	
	
	
	
	@Test
	public void testMaxChars() {
		
		String testInput = "test";
		
		char [] maxCharsExpected = {'t'};
		List<Character> actual = maxChar(testInput);
		
		char[] actualChars = new char[actual.size()];
		int index = 0;
		for (char c : actual){
			actualChars[index++] = c;
		}
		
		assertArrayEquals(maxCharsExpected, actualChars);
	}

	
	@Test
	public void testMaxCharsMultiple() {
		
		String testInput = "test mm";
		
		char [] maxCharsExpected = {'t', 'm'};
		List<Character> actual = maxChar(testInput);
		
		char[] actualChars = new char[actual.size()];
		int j = 0;
		for (int i = actual.size()-1; i>=0; i--){
			actualChars[j++] = actual.get(i);
		}
		
		assertArrayEquals(maxCharsExpected, actualChars);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(args[0]);

	}

}
