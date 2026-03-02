import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static HashMap<String, Integer> words;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		words = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.length() >= M) {
				words.put(input, words.getOrDefault(input, 0) + 1);
			}
		}

		List<String> keySet = new ArrayList<String>(words.keySet());
		keySet.sort((o1, o2) -> {
			if (words.get(o1) != words.get(o2)) {
				return words.get(o2) - words.get(o1); // 내림차순
			}

			if (o1.length() != o2.length()) { // 길이
				return o2.length() - o1.length(); // 내림차순
			}

			return o1.compareTo(o2); // 사전순
		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
		for (String key : keySet) {
			bw.write(key + "\n");
		}
		bw.flush();
		bw.close();

	}

}