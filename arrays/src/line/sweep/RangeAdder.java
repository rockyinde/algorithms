package line.sweep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Operation is defined as:
 * 	in an array on the range of indices (a, b) add k
 * 
 * M such operations
 * 
 * Return the maximum of the array, after the operations are applied
 * 
 * @author rockyinde
 *
 */
public class RangeAdder {

	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		String[] tokens = br.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		
		long[] list = new long[n+1];
		
		for (int i = 0; i < m; i++) {
			
			tokens = br.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			int k = Integer.parseInt(tokens[2]);
			
			list[a-1] += k;
			list[b] -= k;
		}
		
		long max = 0;
		long curr = 0;
		
		for (int i = 0; i < n; i++) {
			
			curr += list[i];
			if (curr > max)
				max = curr;
		}
		
		System.out.println(max);
	}
}
