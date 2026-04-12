#include <iostream>				// cin, cout

using namespace std;

int n;
long long dp[117];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	dp[1] = dp[2] = dp[3] = 1;

	for (int i = 4; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 3];
	}

	cout << dp[n] << '\n';

	return 0;

}

