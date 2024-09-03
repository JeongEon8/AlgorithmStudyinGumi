#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

// 전역변수
int N, M;
int arr[500][500];
int result = 0;
bool visited[500][500];

// 방향벡터	 상 하 좌 우
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };

void print() {
	cout << endl;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << visited[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

void backTracking(int sum, int x, int y, int cnt) {
	if (cnt >= 4) {
		result = max(result, sum);
		//print();
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
			continue;
		}

		if (visited[ny][nx] == true) {
			continue;
		}

		if (visited[ny][nx] == false) {
			visited[ny][nx] = true;
			backTracking(sum + arr[ny][nx], nx, ny, cnt + 1);
			visited[ny][nx] = false;
		}
	}
}


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	memset(visited, false, sizeof(visited));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			visited[i][j] = true;
			backTracking(arr[i][j], j, i, 1);
			visited[i][j] = false;

			int up = i + 1;
			int down = i - 1;
			int right = j + 1;
			int left = j - 1;
			
			// ㅗ
			if (0 <= up && up < N && 0 <= left && left < M && 0 <= right && right < M) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][left] + arr[i][right]));
			}
			
			// ㅏ
			if (0 <= up && up < N && 0 <= right && right < M && 0 <= down && down < N) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][right] + arr[down][j]));
			}

			// ㅜ
			if (0 <= down && down < N && 0 <= left && left < M && 0 <= right && right < M) {
				result = max(result, (arr[i][j] + arr[down][j] + arr[i][left] + arr[i][right]));
			}

			// ㅓ
			if (0 <= up && up < N && 0 <= left && left < M && 0 <= down && down < N) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][left] + arr[down][j]));
			}
		}
	}

	cout << result << '\n';

	return 0;
}
