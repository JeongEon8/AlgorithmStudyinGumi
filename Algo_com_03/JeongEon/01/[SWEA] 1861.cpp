#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

// 전역 변수
int N;
//int visited[1001][1001];
int room[1000][1000];
int cnt = 0;

// 방향벡터 상 하 좌 우
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };

// 탐색 함수 // <--- 시간 초과. 불필요한 곳까지 탐색했기 때문.
//int BFS(int i, int j) {
//	int maxi = 1;
//
//	queue<pair<int, int>> q;
//	q.push({ i, j });
//
//	while (q.empty() == false) {
//		int y = q.front().first;
//		int x = q.front().second;
//		q.pop();
//
//		for (int k = 0; k < 4; k++) {
//			int ny = dy[k] + y;
//			int nx = dx[k] + x;
//
//			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] != 0) {
//				continue;
//			}
//
//			if (room[ny][nx] - room[y][x] == 1) {
//				visited[ny][nx] = visited[y][x] + 1;
//				maxi = max(maxi, visited[ny][nx]);
//				q.push({ ny, nx });
//			}
//		}
//	}
//
//	return maxi;
//}

void DFS(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
			continue;
		}

		if (room[ny][nx] - room[y][x] == 1) { // <--- 이 조건이 있기 때문에 방문배열이 필요없다.
			cnt++;
			DFS(ny, nx);
		}
	}
}


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		// 입력
		cin >> N;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> room[i][j];
			}
		}

		// 탐색
		pair<int, int> result = { 0, 0 };
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//memset(visited, 0, sizeof(visited));
				//int cnt = DFS(i, j);
				cnt = 1;
				DFS(i, j);
				if ((cnt > max) || (cnt == max && room[i][j] < room[result.first][result.second])) {
					max = cnt;
					result = { i, j };
				}
			}
		}

		// 출력
		cout << "#" << tc << " ";
		cout << room[result.first][result.second] << " " << max << '\n';
	}

	return 0;
}
