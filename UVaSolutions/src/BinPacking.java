import java.io.PrintWriter;
import java.util.Scanner;

class BinPacking {
	
	private Scanner in = new Scanner(System.in);
	private PrintWriter out = new PrintWriter(System.out, true);
	
	private char[] types;
	private int[][] permutations;
	
	private static final int _NO_OF_BINS = 3;
	private static final int _BOTTLE_TYPES = 3;
	
	private int optMoveCount;
	private String optPermutation; 
	
	
	public BinPacking(){
		types = new char[]{'B','G','C'};
		permutations = new int[][] {
				{0,1,2},
				{0,2,1},
				{1,0,2},
				{1,2,0},
				{2,0,1},
				{2,1,0}
		};
	}
		
	private String permutationString(int permutationIndex){
		String retString = "";
		for(int i = 0;i<_NO_OF_BINS;i++){
			retString += types[permutations[permutationIndex][i]];
		}
		return retString; 
	}
	
	private void initState(){
		optMoveCount = -1;
		optPermutation = ""; 
		
	}
	
	/**
	 * A brute-force algorithm to determine a bin configuration that yield 
	 * optimal (minimum) bin movements.
	 * 
	 * @param input 
	 *  
	 * @return a String that represents OPT bin configuration 
	 * that yields minimum movement. 
	 */
	String getOPTConfiguration(int[][] input){
		initState();
		
		for (int pi = 0;pi<permutations.length;pi++){
			int currentMoveCount = 0;
			
			for (int bno=0;bno<_NO_OF_BINS;bno++){
				int allowedType = permutations[pi][bno];
				for(int btype = 0; btype<_BOTTLE_TYPES;btype++){
					if (allowedType!=btype){
						currentMoveCount += input[bno][btype]; 
					} 
				}
			}
			
			String currentPermutation = permutationString(pi);
			
			if ((this.optMoveCount == -1) || 
				(currentMoveCount < optMoveCount) || 
				((currentMoveCount == optMoveCount) && (currentPermutation.compareTo(optPermutation)<0))){
				
				this.optMoveCount = currentMoveCount;
				this.optPermutation = currentPermutation;
			}
		}
		
		return optPermutation+" "+optMoveCount;
	}
	
	public void solve(){
		int[][] inputBottles = new int[_NO_OF_BINS][_BOTTLE_TYPES];
		while (in.hasNextInt()){
			for(int i = 0;i<_NO_OF_BINS;i++){
				for (int j=0;j<_BOTTLE_TYPES;j++){
					inputBottles[i][j] = in.nextInt();
				}
			}
			out.println(getOPTConfiguration(inputBottles));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinPacking binPackingSolver = new BinPacking();
		binPackingSolver.solve();
	}
	
}

