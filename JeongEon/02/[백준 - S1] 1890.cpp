#include <iostream>				// cin, cout

using namespace std;

// 방향 벡터 - 오른쪽, 아래쪽
int dx[2] = { 1, 0 };
int dy[2] = { 0, 1 };

int N;
int board[101][101];
long long dp[101][101];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}

	dp[0][0] = 1;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (dp[i][j] == 0 || board[i][j] == 0) {
				continue;
			}

			for (int k = 0; k < 2; k++) {
				int ny = board[i][j] * dy[k] + i;
				int nx = board[i][j] * dx[k] + j;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				dp[ny][nx] += dp[i][j];
			}
		}
	}

	cout << dp[N - 1][N - 1];

	return 0;
}
