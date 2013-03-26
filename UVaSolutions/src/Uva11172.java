import java.io.PrintWriter;
import java.util.Scanner;

public class Uva11172 {
	private final Scanner in;
	private final PrintWriter out;

	public Uva11172() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}

	public Uva11172(Scanner in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}
	private int[] getInts(String input) {
		String[] ints = input.trim().split(" ");
		int[] rets = new int[2];

		rets[0] = Integer.parseInt(ints[0]);
		rets[1] = Integer.parseInt(ints[1]);

		return rets;
	}

	public void run() {
		
		int T  = Integer.parseInt(in.nextLine().trim());
		int currentTestCase = 0;
		
		for (;currentTestCase<T;currentTestCase++){
			int [] rets = getInts(in.nextLine());
			int result = rets[0] - rets[1];
			
			if (result == 0)
				out.println("=");
			else if (result < 0)
				out.println("<");
			else if (result > 0)
				out.println(">");
				
		}
	}

	public static void main(String[] args) {
		
		Uva11172 solver = new Uva11172();
		solver.run();
	}

}