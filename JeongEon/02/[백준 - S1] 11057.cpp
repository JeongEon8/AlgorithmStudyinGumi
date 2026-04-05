#include <iostream>			// cin, cout

#define mod 10007

using namespace std;

int N;
long long dp[1001][10];


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				dp[i][0] = 1;
				continue;
			}
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			dp[i][j] %= mod;
		}
	}

	long long result = 0;
	for (int i = 0; i < 10; i++) {
		result += dp[N][i];
	}

	cout << result % mod;

	return 0;

}

