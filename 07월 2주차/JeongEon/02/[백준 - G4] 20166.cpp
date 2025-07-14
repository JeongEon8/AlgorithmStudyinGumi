#include <iostream>
#include <map>

using namespace std;

int N, M, K;
int dy[8] = { 1, 1, 0, -1, -1, -1, 0, 1 };
int dx[8] = { 0, 1, 1, 1, 0, -1, -1, -1 };
string board[11];
map <string, int> caseMap;

void dfs(int nowY, int nowX, int depth, string s) {
	if (depth == 5) {
		return;
	}
	caseMap[s]++;

	for(int i = 0; i < 8; i++) {
		int ny = nowY + dy[i];
		int nx = nowX + dx[i];

		if (0 > ny) {
			ny = N - 1;
		}
		if(0 > nx) {
			nx = M - 1;
		}
		if(ny >= N) {
			ny = 0;
		}
		if(nx >= M) {
			nx = 0;
		}
		dfs(ny, nx, depth + 1, s + board[ny][nx]);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N >> M >> K;
	for(int i = 0; i < N; i++) {
		cin >> board[i];
	}

	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++) {
			string start = "";
			dfs(i, j, 0, start + board[i][j]);
		}
	}

	while (K--) {
		string s;
		cin >> s;
		cout << caseMap[s] << '\n';
	}

	return 0;
}
