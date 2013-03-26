/*
 *  @author  Adil Akhter
 *  @judge  UVa
 *  @problemId  371 
 *  @problemName Ackermann Functions
 *  @link    http://uva.onlinejudge.org/external/3/371.html
 *  @verdict  Accepted
 *  @category  add-hoc
 *  @level  easy
 *  @date  14/03/2013
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class UVa371 {
	private final Scanner in;
	private final PrintWriter out;

	private final static int _MaxValue = 1000000;
	private final static long[] memo = new long[_MaxValue];

	public UVa371() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out, true);
	}

	public UVa371(Scanner in, PrintWriter out) {
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

	private void solveAckermannProblem(long from, long to) {
		long maxValue = from;
		long maxLength = 0;

		for (long i = from; i <= to; i++) {
			long length = computeCycleLength(nextAckermannNumber(i));
			if (maxLength < length) {
				maxValue = i;
				maxLength = length;
			}
		}

		out.println(String
				.format("Between %d and %d, %d generates the longest sequence of %d values.",
						from, to, maxValue, maxLength));
	}

	private static long computeCycleLength(long n) {
		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		if (n < _MaxValue && memo[(int) n] != 0)
			return memo[(int) n];

		long len = 1 + computeCycleLength(nextAckermannNumber(n));// computing
																	// length of
																	// Ackermann
																	// sequence

		if (n < _MaxValue) // storing it in cache
			memo[(int) n] = len;

		return len;
	}

	public static long nextAckermannNumber(long n) {
		if (n % 2 == 0)
			return n / 2;
		else
			return n * 3 + 1;
	}

	public void run() {
		while (in.hasNextLine()) {
			long[] range = getInts(in.nextLine());

			if ((range[0] == 0) && (range[1] == 0))
				break;

			long from = Math.min(range[0], range[1]);
			long to = Math.max(range[0], range[1]);

			solveAckermannProblem(from, to);
		}
	}

	public static void main(String[] args) {

		UVa371 solver = new UVa371();
		solver.run();
	}

}
