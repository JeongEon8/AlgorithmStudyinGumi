#include <iostream>			// cin, cout

using namespace std;

int T;				// 테스트 케이스 개수
int n;				// 정수
long long DP[1000001][4];	// 방법수

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	DP[1][1] = 1;
	DP[2][2] = 1;
	DP[3][1] = 1;
	DP[3][2] = 1;
	DP[3][3] = 1;

	for (int i = 4; i <= 1000000; i++) {
		if (i - 1 >= 0) {
			DP[i][1] = (DP[i - 1][2] + DP[i - 1][3]) % 1000000009;
		}
		if (i - 2 >= 0) {
			DP[i][2] = (DP[i - 2][1] + DP[i - 2][3]) % 1000000009;
		}
		if (i - 3 >= 0) {
			DP[i][3] = (DP[i - 3][1] + DP[i - 3][2]) % 1000000009;
		}
	}

	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> n;
		cout << (DP[n][1] + DP[n][2] + DP[n][3]) % 1000000009 << '\n';
	}

	return 0;
}

