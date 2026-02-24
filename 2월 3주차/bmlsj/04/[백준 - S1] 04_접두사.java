import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static String[] words;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words);
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			boolean isPrefix = false;
			for(int j = i + 1; j < N; j++) {
				if (words[j].startsWith(words[i])) {
					isPrefix = true;
					break;
				}
			}
			
			if (!isPrefix) count++;
		}
		
		System.out.println(count);
	}

}