/**
 * 
 */

/**
 * @author adil
 *
 */
public class StrstrMain {

	//a b x b c d x 
	//- - - b c d - 
	public static int Search(String heystack, String needle){
		
		for ( int i = 0; i < heystack.length(); i++){
			for ( int j = 0;  (j < needle.length()) && ((i+j) < heystack.length()); j++){
				if( needle.charAt(j) != heystack.charAt(i+j)){
					break;
				}
				else if( j == needle.length()-1){
					return i; 
				}
			}
		}	
		
		
		return -1; 
	}
	
	
	public static int strstr (String heystack, String neddle){
		for(int i = 0; i< heystack.length() ; i ++){
			for ( int j =  0 ; (j< heystack.length()) && (i+j<neddle.length()) ; j++){
				 if(neddle.charAt(i) != heystack.charAt(i+j))
					break; // check whether it matches
				else	// check whether complete string is matched
					if (j == neddle.length()-1)
						return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	
		System.out.println(Search("ab__bcd__xx" , "bcd")); //4
		
		System.out.println(Search("bcda" , "bcd")); //0
		
		System.out.println(Search("abcd" , "bcd")); //1
		
		System.out.println(Search("abc-d--" , "bcd")); //-1
		
		System.exit(0);
	
	
	}

	
}
