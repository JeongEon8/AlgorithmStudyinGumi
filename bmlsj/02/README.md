# [PGS - lv2] 02.석유 시추

## ⏰**time**

30분

## :pushpin: **Algorithm**

dfs

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. DFS로 석유 덩어리 구분

- 연결된 1들을 하나의 구역으로 묶고 groupId 부여
- 각 구역의 크기를 groupSize에 저장

2. 열 기준으로 석유량 계산

- 각 열마다 포함된 서로 다른 구역 id를 set에 저장
- 해당 구역들의 크기를 모두 함

3. 최대값 반환

- 열별 합 중 최댓값을 답으로 선택

```java
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
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/250136>

