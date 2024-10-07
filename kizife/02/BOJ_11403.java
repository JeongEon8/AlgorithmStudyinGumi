import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		int[][] result = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Queue<Integer> queue;
		boolean[] visited;
		
		for(int i = 0; i < n; i++) { // 각 정점마다 탐색을 진행한다 
			
			queue = new LinkedList<Integer>();
			visited = new boolean[n];
			queue.offer(i);
			
			int tmp;
			while(!queue.isEmpty()) {
				tmp = queue.poll();
				for(int j = 0; j < n; j++) {
					if(map[tmp][j] == 1 && visited[j] != true) {
						queue.offer(j);
						visited[j] = true;
						result[i][j] = 1; // 만약 i번째 정점에서 j를 거친다면 1을 표시
					}
				}
			}
		}
		
		// 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++)
				System.out.print(result[i][j]+" ");
			System.out.println();
		}
	}
}
