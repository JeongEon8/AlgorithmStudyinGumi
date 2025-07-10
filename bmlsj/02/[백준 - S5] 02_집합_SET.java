import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			String[] split = br.readLine().split(" ");

			String cmd = split[0];
			int x = 0;
			if (split.length > 1) {
				x = Integer.parseInt(split[1]);
			}

			switch (cmd) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "check":
				bw.write(set.contains(x) ? "1\n" : "0\n");
				break;
			case "toggle":
				if (set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
				break;
			case "all":
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		bw.flush();  
        bw.close();
        br.close();

	}

}
