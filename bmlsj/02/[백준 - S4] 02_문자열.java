import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		String A = split[0];
		String B = split[1];

		int aLen = A.length();
		int bLen = B.length();

		int minDiff = Integer.MAX_VALUE;
		for (int start = 0; start <= bLen - aLen; start++) {
			int diff = 0;
			for (int i = 0; i < aLen; i++) {
				if (A.charAt(i) != B.charAt(start + i))
					diff++;
			}
			minDiff = Math.min(minDiff, diff);
		}

		System.out.println(minDiff);
	}

}
