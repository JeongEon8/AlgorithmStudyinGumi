#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

// 전역변수
int N;
int arr[26][26];
bool visited[26][26];
int cnt;
vector<int> result;

// 방향벡터
			// 오 왼 위 아래 
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void print() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << visited[i][j];
		}
		cout << endl;
	}
}

void DFS(int y, int x) {
	cnt++;
	visited[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
			continue;
		}

		if (arr[ny][nx] == 1 && visited[ny][nx] == false) {
			DFS(ny, nx);
		}
	}
}

int main(void) {
	cin >> N;

	for (int i = 0; i < N; i++) {
		string input;
		cin >> input;
		for (int j = 0; j < N; j++) {
			arr[i][j] = input[j] - '0';
		}
	}

	memset(visited, false, sizeof(visited));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (arr[i][j] == 1 && visited[i][j] == false) {
				cnt = 0;
				DFS(i, j);
				result.push_back(cnt);
				//print();
			}
		}
	}

	sort(result.begin(), result.end());

	cout << result.size() << endl;

	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << endl;
	}
	return 0;
}
