import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int rows = 0;
		int columns = 0;
		int[] columnSpace = new int[n];
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			String[] split = line.split("X");
			for (String space : split) {
				if (space.length() > 1) {
					rows++;
				}
			}
			for (int j = 0; j < n; j++) {
				char c = line.charAt(j);
				if (c == 'X') {
					if (columnSpace[j] > 1)
						columns++;
					columnSpace[j] = 0;
				} else {
					columnSpace[j]++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (columnSpace[i] > 1)
				columns++;

		}
		System.out.println(rows + " " + columns);

	}

}