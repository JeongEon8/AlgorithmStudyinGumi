import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> worker = new TreeMap<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			String name = split[0];
			String status = split[1];

			if (status.equals("enter")) {
				worker.put(name, 0);
			} else {
				worker.put(name, 1);
			}
		}

		for(String name: worker.keySet()) {
			int status = worker.get(name);
			if (status == 0) {
				System.out.println(name);
			}
		}

	}

}
