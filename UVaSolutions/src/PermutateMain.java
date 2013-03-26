import junit.framework.TestCase;

// Permutation 

// Test permuation of a String 
// complexity O(n!)
public class PermutateMain  extends TestCase {

	
	public String swap(String s , int i , int j){
		
		char [] chars = s.toCharArray();
		
		if ( i < s.length() && j < s.length()){
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		
		return new String(chars);
	}
	
	public void testSwapString()
	{
		String expected= "acbd";
		String actual  =  swap("abcd", 1, 2);
		
		assertEquals(expected, actual);
		
		expected= "adcb";
		actual  =  swap("abcd", 1, 3);
		
		assertEquals(expected, actual);
	
		
	}
	
	
	
	public void permute(String str, int i , int n){
		
	//	System.out.println(i + ":= " +str );
		
		if (i == n)
			System.out.println(str);
		else{
			
			for (int j = i; j<= n ; j++ ){
				str = swap(str, i, j); // fixing 
				permute(str, i+1 , n);   // permutating 
				str=swap(str, i, j);   // backtracking 
			}
		}
		
	}
	
	public void permute(String str){
		permute(str, 0, str.length() -1);
	}
	
	public static void main(String[] args) {

		PermutateMain m = new PermutateMain();
		
		m.permute("abc");
		
		System.exit(0);
	}
}
