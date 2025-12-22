import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int len = str.length();
		List<String> suffixList = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			suffixList.add(str.substring(i, len));
		}
		Collections.sort(suffixList);
		StringBuilder sb = new StringBuilder();
		for (String suffix : suffixList) {
			sb.append(suffix).append('\n');
		}
		System.out.println(sb);
	}

}