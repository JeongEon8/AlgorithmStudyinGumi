import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] matrixA = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				matrixA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int newM = m - w + 1;
		int newN = n - w + 1;
		for (int i = 0; i < newM; i++) {
			for (int j = 0; j < newN; j++) {
				List<Integer> tmp = new ArrayList<>();
				for (int x = 0; x < w; x++) {
					for (int y = 0; y < w; y++) {
						tmp.add(matrixA[i + x][j + y]);
					}
				}
				Collections.sort(tmp);
				sb.append(tmp.get((w * w) / 2)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}