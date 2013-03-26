import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Uva713 {
	
	private final Scanner in;
	private final PrintWriter out;
	
	public Uva713(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}
	
	public Uva713(Scanner in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
	
	private static BigInteger bigIntAfterRemovingTrailingZeros(String num){
		int nonZeroIndex=num.length()-1; 
		for (; nonZeroIndex>=0; nonZeroIndex--){
			if (num.charAt(nonZeroIndex) != '0'){
				break;
			}
		}
		return new BigInteger(num.substring(0, nonZeroIndex+1));
	
	}
	
	private static BigInteger[] readLineAsBigInts(String input){
		String [] ints = input.trim().split(" ");
		BigInteger [] rets = new BigInteger[2];

		rets[0] = bigIntAfterRemovingTrailingZeros(ints[0]);
		rets[1] = bigIntAfterRemovingTrailingZeros(ints[1]);
		
		return rets;
	}
	
	private static BigInteger reversedBigInt(BigInteger num1){
		BigInteger reversedNum = BigInteger.ZERO;
		final int _REM = 1;
		final int _QUOTIENT = 0;
		
		while (num1.compareTo(BigInteger.ZERO)>0){
			BigInteger [] results = num1.divideAndRemainder(BigInteger.TEN);
			
			reversedNum = reversedNum.add(results[_REM]);
			if(num1.compareTo(BigInteger.TEN)>=0)
				reversedNum =reversedNum.multiply(BigInteger.TEN);
			
			num1 = results[_QUOTIENT];
		}
		
		return reversedNum;
	}
	
	private static BigInteger getAddRevNumbers(BigInteger num1, BigInteger num2){
		return  reversedBigInt(reversedBigInt(num1).add(reversedBigInt(num2)));
	}
	
	public void run(){
		final int T = Integer.parseInt(in.nextLine().trim()); // no of test cases  
		BigInteger [] numbers;
		
		for (int testCase = 0 ; testCase< T ; testCase++){
			numbers = readLineAsBigInts(in.nextLine());// read input
			out.println(getAddRevNumbers(numbers[0], numbers[1]));// 	print result
		}
	}
	
	public static void main(String[] args) {
		Uva713_2 uva713Solver = new Uva713_2();
		uva713Solver.run();
	}
	
}