#include <iostream>
#include <cstdlib>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int N;	// 지도의 크기
int complex = 0;	// 아파트 단지수
int house = 0; // 한 단지당 세대수

int map[25][25];	// 지도
bool visited[25][25] = { false };	// 방문했는지 확인
vector<int> result;		// 결과값 저장

// 방향벡터
			// 오 왼 위 아래 
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void dfs(int i, int j);

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 입력
	cin >> N;

	string input;
	for (int i = 0; i < N; i++) {
		cin >> input;
		for (int j = 0; j < N; j++) {
			map[i][j] = input.at(j) - '0';
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 1 && visited[i][j] == false) {
				dfs(i, j);
				complex++;
				result.push_back(house);
				house = 0;
			}
		}
	}


	// 오름차순으로 정렬
	sort(result.begin(), result.end());

	// 출력) 첫 번째 줄에는 총 단지수를 출력, 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력
	cout << complex << '\n';
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << '\n';
	}

	return 0;
}

void dfs(int y, int x) {
	visited[y][x] = true;
	house++;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
			continue;
		}

		if (map[ny][nx] == 1 && visited[ny][nx] == false) {
			dfs(ny, nx);
		}
	}
}
