import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  @author Md. Adil Akhter
 *  @judge  UVa OJ
 *  @problemId  10706
 *  @problemName Number Sequence
 *  @link    http://uva.onlinejudge.org/external/107/10706.html
 *  @verdict  
 *  @category  Binary Search, Simulation 
 *  @level  easy
 *  @date  18/03/2013 5:30:24 PM
 */
 
class Main {

	private final Scanner in;
	private final PrintWriter out;

	public Main() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}

	public Main(Scanner in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	private static long[] getInts(String input) {
		String[] ints = input.trim().split(" ");
		long[] rets = new long[2];

		rets[0] = Long.parseLong(ints[0]);
		rets[1] = Long.parseLong(ints[1]);

		return rets;
	}


	

	public void run() {
		while (in.hasNextLine()) {
			long[] range = getInts(in.nextLine());
			// read input 
			
			// write output
		}
	}


	public static void main(String[] args) {
		
		Main solver = new Main();
		solver.run();
	}

}