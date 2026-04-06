import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int block[][];
	static int shopInfo[][];
	static int row, col, shopNum, Dong;
	static int dx[] = { 0, 0, 0, -1, 1 };
	static int dy[] = { 0, 1, -1, 0, 0 };
	static int distance;
	static int dir, shopDistance1, shopDistance2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		block = new int[row + 1][col + 1];
		shopNum = Integer.parseInt(br.readLine());
		shopInfo = new int[shopNum + 1][2];
		int arr[] = new int[shopNum + 1];

		//1 북 2 남 3 서 4 동
		for (int i = 1; i < shopNum + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());

			if (direction == 1) {
				arr[i] = position;
			}
			if (direction == 2) {
				arr[i] = (row-position) + row + col;
			}
			if (direction == 3) {
				arr[i] = (col-position) + (2*row) + col;
			}
			if (direction == 4) {
				arr[i] = position + row;
			}
		}
		st = new StringTokenizer(br.readLine());

		int dongDir = Integer.parseInt(st.nextToken());
		int dong = Integer.parseInt(st.nextToken());
		
		int dongPosition = 0;
		
		if (dongDir == 1) {
			dongPosition = dong;
		}
		if (dongDir == 2) {
			dongPosition  = (row-dong) + row + col;
		}
		if (dongDir == 3) {
			dongPosition = (col-dong) + (2 * row) + col;
		}
		if (dongDir == 4) {
			dongPosition = dong + row;
		}
		
		int result = 0;
		int min = 400;
	
		for(int i = 1; i < shopNum+1; i++) {
			int shopDistance1 = Math.abs(arr[i] - dongPosition);
			int shopDistance2 = (2*(row+col) - shopDistance1);
			min = Math.min(shopDistance1, shopDistance2);
			result += min;
		}
		
		System.out.println(result);

	}

}