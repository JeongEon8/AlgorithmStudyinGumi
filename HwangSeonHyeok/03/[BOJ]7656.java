import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] sentences = in.readLine().split("(?<=.)(?=[A-Z])");
		StringBuilder sb = new StringBuilder();
		for (String sentence : sentences) {
			String trimedString = sentence.trim();
			if (trimedString.startsWith("What is") && trimedString.endsWith("?")) {
				String ans = "Forty-two" + trimedString.substring(4, trimedString.length() - 1) + ".\n";
				sb.append(ans);
			}
		}
		System.out.println(sb);
	}

}