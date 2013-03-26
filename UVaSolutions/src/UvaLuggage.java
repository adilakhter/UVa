import java.io.PrintWriter;
import java.util.Scanner;

public class UvaLuggage {
	
	private final Scanner in;
	private final PrintWriter out;
	
	public UvaLuggage(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}
	
	public UvaLuggage(Scanner in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
	
	private static int[] readLineAsIntegers(String input){
		String [] ints = input.trim().split(" ");
		int [] rets = new int[ints.length];

		for (int i = 0 ;i < ints.length; i++)
			rets[i] = Integer.parseInt(ints[i]);
		
		return rets;
	}
	
	private String solveLuggageProblem(int[] weights){
		final String _TRUE = "YES";
		final String _FALSE = "NO";
		
		int totalWeight = getTotalWeight(weights);
		
		if (totalWeight%2 != 0)
			return _FALSE;
		
		int n = weights.length+1;
		int halfWeight = totalWeight/2;
		
		boolean [][] dpTable = new boolean [n][halfWeight+1];
		
		// Base case 1: weights = 0 for all n --> True 
		for(int i = 0;i<n;i++)
			dpTable[i][0] = true;
		
		// Base case 2: weights !=0 for all n=0 --> False  
		for(int i = 1;i<halfWeight+1;i++)
			dpTable[0][i] = false;
		
		for (int i = 1; i< n; i++ ){
			
			for (int j = 1; j< halfWeight+1; j++){
				
				int w_i = weights[i-1]; // weight of ith item
				
				if(j<w_i) // this item can't be included since its over the limit:j 
					dpTable[i][j] = dpTable[i-1][j];
				else 
					dpTable[i][j] = dpTable[i-1][j] || dpTable[i-1][j-w_i]; 
			}
		}
		
		return dpTable[n-1][halfWeight]==true?_TRUE:_FALSE;
		
	}

	private int getTotalWeight(int[] weights) {
		int totalWeight = 0;
		// compute total weight of the bags
		for(int indx =0;indx< weights.length;indx++){
			totalWeight += weights[indx]; 
		}
		return totalWeight;
	}
	
	public void run(){
		final int T = Integer.parseInt(in.nextLine().trim()); // no of test cases  
		
		for (int i = 0 ; i< T ; i++){
			int [] weights = readLineAsIntegers(in.nextLine());		
			
			// result:
			out.println(solveLuggageProblem(weights));
		}
	}
	
	
	public static void main(String[] args) {
		
		UvaLuggage solveLuggageProblem = new UvaLuggage();
		solveLuggageProblem.run();
	}
	
}