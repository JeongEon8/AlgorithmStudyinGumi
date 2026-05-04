import java.util.*;
class Solution {
    
    static int n, m;
	static int[][] group;
	static Map<Integer, Integer> groupSize = new HashMap<>();
	static int groupId = 1;
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
		m = land[0].length;

		calcVolume(land);
		answer = ansVolume(land);
        
        return answer;
    }
    
    static int ansVolume(int[][] land) {

		int ans = 0;

		for (int i = 0; i < m; i++) {
			HashSet<Integer> set = new HashSet<>();
			int tmp = 0;

			for (int j = 0; j < n; j++) {
				if (group[j][i] == 0)
					continue;
				set.add(group[j][i]); // group id 기준
			}

			for (int id : set) {
				tmp += groupSize.get(id);
			}

			ans = Math.max(ans, tmp);
		}

		return ans;
	}
	
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void calcVolume(int[][] land) {

		visited = new boolean[n][m];
		group = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && land[i][j] == 1) {

					int size = dfs(i, j, land, groupId);
					groupSize.put(groupId, size);
					groupId++;
				}
			}
		}
	}


	static int dfs(int x, int y, int[][] land, int id) {
		visited[x][y] = true;
		group[x][y] = id;

		int cnt = 1;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (!visited[nx][ny] && land[nx][ny] == 1) {
				cnt += dfs(nx, ny, land, id);
			}
		}

		return cnt;
	}

}