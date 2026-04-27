#include <iostream>		// cin, cout

using namespace std;

int n, m;
long long int DP[1001][1001];

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	DP[0][0] = 1;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			DP[i][j] = (DP[i - 1][j] + (DP[i][j - 1] + DP[i - 1][j - 1]) % 1000000007) % 1000000007;
		}
	}

	cout << DP[n][m] << '\n';

	return 0;
}
