//미완입니다!!!!!

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //각 지점에서의 최단거리들을 구하고, 그들 중 최대값 추출하기

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		int n = sc.nextInt();
		int m = sc.nextInt();
	
		char[][] map = new char[n][m]; //지도 생성 

		for(int i=0; i<n; i++) { //지도 채워주기 
			String str = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		boolean[][] visited;
		
		for(int i=0; i<n; i++) { //육지 확인하기
			for(int j=0; j<m; j++) {
				if(map[i][j] == "L") {
					visited = new boolean[n][m];

					int length = bfs(i, j);
					int max = Math.max(max, length);
				}
			
			}



    }
}
