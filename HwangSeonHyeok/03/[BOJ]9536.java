import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		String question = "what does the fox say?";
		for (int i = 0; i < n; i++) {
			String[] growls = in.readLine().split(" ");
			Map<String, Boolean> map = new HashMap<>();
			while (true) {
				String line = in.readLine();
				if (line.equals(question))
					break;
				String[] split = line.split(" ");
				map.put(split[2], true);
			}
			for (String growl : growls) {
				if (!map.containsKey(growl))
					sb.append(growl).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}