import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

class Uva713_2 {
	
	private final Scanner in;
	private final PrintWriter out;
	
	public Uva713_2(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}
	
	public Uva713_2(Scanner in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
	
	
	private static String reverseString(String num){
		char[] numArray = num.toCharArray();
		char[] reversed = new char[numArray.length];
		
		for (int i = numArray.length-1; i>=0 ; i--){
			reversed[(numArray.length-1)-i] = numArray[i]; 
		}
		
		return new String(reversed);
		
	}
	private static String bigIntAfterRemovingTrailingZeros(String num){
		int nonZeroIndex=num.length()-1; 
		for (; nonZeroIndex>=0; nonZeroIndex--){
			if (num.charAt(nonZeroIndex) != '0'){
				break;
			}
		}
		
		return new String(num.substring(0, nonZeroIndex+1));
	
	}
	
	private static String[] readLineAsBigInts(String input){
		String [] ints = input.trim().split(" ");
		String [] rets = new String[2];

		rets[0] = bigIntAfterRemovingTrailingZeros(ints[0]);
		rets[1] = bigIntAfterRemovingTrailingZeros(ints[1]);
		
		return rets;
	}
	
	
	private static BigInteger bigInt(String s){
		return new BigInteger(s);
	}
	
	public void run(){
		final int T = Integer.parseInt(in.nextLine().trim()); // no of test cases  
		String [] numbers;
		
		for (int testCase = 0 ; testCase< T ; testCase++){
			numbers = readLineAsBigInts(in.nextLine());// read input
			
			String revNum1 = reverseString(numbers[0]);
			String revNum2 = reverseString(numbers[1]);
			
			BigInteger result =bigInt(revNum1).add(bigInt(revNum2));
			
			out.println(reverseString(bigIntAfterRemovingTrailingZeros(result.toString())));
			//out.println(reverseString(result.toString()));
		}
	}
	
	public static void main(String[] args) {
		Uva713_2 uva713Solver = new Uva713_2();
		uva713Solver.run();
	}
	
}