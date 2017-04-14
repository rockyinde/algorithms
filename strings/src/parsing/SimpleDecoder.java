package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleDecoder {

	enum Type {
		DIGIT, LEFT, RIGHT, HASH;
	}
	
	/*
	 * Complete the function below.
	 */

	static Type getType(char c) {

		if (c == '(')
			return Type.LEFT;
		else if (c == ')')
			return Type.RIGHT;
		else if (c == '#')
			return Type.HASH;
		else
			return Type.DIGIT;
	}
	
	static int[] frequency(String s) {

		int l = s.length();
		
		int[] count = new int[26];
		
		int i = l-1;
		int num = 1;
		while (i >= 0) {
			
			Type type = getType(s.charAt(i));
			
			if (type == Type.DIGIT) {
				
				count[s.charAt(i)-'1'] += num;
				i = i -1;
				num = 1;
			} else if (type == Type.HASH) {
				
				count[Integer.parseInt(s.substring(i-2, i)) - 1] += num;
				num = 1;
				i = i-3;
			} else if (type == Type.RIGHT) {
				
				num = 1;
				StringBuilder sb = new StringBuilder();
				while (s.charAt(--i) != '(') {
					
					sb.append(s.charAt(i));
				}
				num = Integer.parseInt(sb.reverse().toString());
				i--;
			}
		}
		
		return count;
	}
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int[] count = frequency(br.readLine());
		
		System.out.print(count[0]);
		for (int i = 1; i < 26; i++) {
			System.out.print(" "+count[i]);
		}
		
		System.out.println();
		
		br.close();
	}
}
