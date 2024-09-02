import java.util.Scanner;

public class Main {

	static int[][] arr;
	static boolean[] visit;
	static int count = 0;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int p = sc.nextInt();
		arr = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < p; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}

		dfs(1);
		
		System.out.println(count-1);

	}

	private static void dfs(int start) {
		// TODO Auto-generated method stub
		visit[start] = true;
		count++;
		
		for (int i = 0; i <= n; i++) {
			if(arr[start][i] ==1 && !visit[i]) dfs(i);
		}
	}

}
