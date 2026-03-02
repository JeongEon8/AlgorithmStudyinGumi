import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, dir, length;
	static int maxRow, maxCol, smallRow, smallCol;
	static int arr[] = new int[6];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			length = Integer.parseInt(st.nextToken());

			arr[i] = length;

//			maxRow = 0;
//			maxCol = 0;
//			smallRow = 0;
//			smallCol = 0;
			if (dir == 3 || dir == 4) {
				int row = length;

				if (row > maxRow) {
					maxRow = row;
				}

			}
			if (dir == 1 || dir == 2) {
				int col = length;
				if (col > maxCol) {
					maxCol = col;
				}
			}

			for (int k = 0; k < 6; k++) {
				if (arr[k] == maxRow) {
					smallRow = arr[(k + 3)%6];
				}
				if (arr[k] == maxCol) {
					smallCol = arr[(k + 3)%6];
				}
			}
		}
		System.out.println(((maxRow * maxCol) - (smallRow * smallCol))*K);
	}
}