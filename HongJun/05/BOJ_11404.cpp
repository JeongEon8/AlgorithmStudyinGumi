#include <iostream>
#include <algorithm>
#define INF 1000000000
using namespace std;

int n;
int m;
int dp[101][101];

int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	cin >> n;
	cin >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j)
				dp[i][j] = 0;
			else
				dp[i][j] = INF;
		}
	}
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		dp[from][to] = min(dp[from][to],cost);
	}
	for (int k = 1; k <=n; k++) {
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (dp[i][j] == INF) {
				cout << 0 << ' ';
				continue;
			}
			cout << dp[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}