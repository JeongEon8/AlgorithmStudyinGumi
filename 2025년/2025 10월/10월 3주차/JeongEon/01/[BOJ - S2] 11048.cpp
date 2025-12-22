#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
  cout.tie(0);

	int n, m;
	cin >> n >> m;
	vector<vector<int>>arr(n + 1, vector<int>(m + 1, 0));
	vector<vector<int>>dp(n + 1, vector<int>(m + 1, 0));
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> arr[i][j];
			dp[i][j] = arr[i][j];
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], max(dp[i - 1][j], dp[i][j - 1]));
		}
	}
	
	cout << dp[n][m] << '\n';

  return 0;
}
