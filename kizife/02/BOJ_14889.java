import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		arr = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		pair(0, 0);
		System.out.println(min);

	}
	
	static void pair(int index, int count) {
		if (count == N/2) {
			func();
			return;
		}
		
		for (int i = index; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				pair(i+1, count+1);
				visited[i] = false; 
			}
		}
	}
	
	static void func() {
		int num1 =0;
		int num2 =0;
		
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				
				if (visited[i] == true && visited[j] == true) {
					num1 += arr[i][j];
					num1 += arr[j][i];
				}

				else if (visited[i] == false && visited[j] == false) {
					num2 += arr[i][j];
					num2 += arr[j][i];
				}
			}
		}
		
		
		int result = Math.abs(num1 - num2);
		
		if (result == 0) {
			System.out.println(result);
			System.exit(0);
		}
		
		min = Math.min(result,  min);
	}
	
	
}
