import java.util.Scanner;

public class BOJ_21278 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <=n; j++) {
				if (i!=j) arr[i][j] = 100; //거리 100으로 임시 초기화 
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		}
		
		
		for (int i = 1; i <=n; i++) { //중간에 경유할 수 있는 지점
			for (int j = 1; j <=n; j++) { //출발하는 빌딩 
				for (int k = 1; k <=n; k++) { //도착점 
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]); //바로 가기 vs. 경유하기 
				}
			}
		}
		
		int min = Integer.MAX_VALUE; //최소값 대충 임시로 설정해줌 
		int building1 = -1;
		int building2 = -1;
		
		for (int i = 1; i <=n; i++) { //치킨집1 
			for (int j = i+1; j <=n; j++) { //치킨집2 
				int sum = 0; //치킨집 조합 바뀔 때마다 초기화해줌 
				
				for (int k = 1; k <=n; k++) { //빌딩k에서 치킨집까지의 거리 합 
					sum += Math.min(arr[k][i], arr[k][j]) *2;
					//왕복이니까 *2 해줌 
					//i, j까지의 거리 중 가까운 것을 선택해서 더함 
				}
				
				if (sum < min) { //치킨집 조합 바뀌었을 때 최소값이 더 작다면, 갱신해줌.
					min = sum;
					building1 = i;
					building2 = j;
				}
			}
		}
		
		System.out.println(building1 +" "+ building2 + " "+min);
		
		
	}

}
