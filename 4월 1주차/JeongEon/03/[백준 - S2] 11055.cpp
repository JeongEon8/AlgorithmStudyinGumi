#include <iostream>			// cin, cout
#include <cmath>			// max

using namespace std;

int N;
int arr[1001];
int dp[1001];


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < N; i++) {
		dp[i] = arr[i];
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				dp[i] = max(dp[i], dp[j] + arr[i]);
			}
		}
	}

	int result = dp[0];
	for (int i = 1; i < N; i++) {
		if (result < dp[i]) {
			result = dp[i];
		}
	}
	
	cout << result;

	return 0;

}

