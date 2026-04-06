#include <iostream>				// cin, cout
#include <algorithm>			// fill_n

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

	fill_n(dp, sizeof(dp) / sizeof(int), 1);


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] < arr[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}

	int result = dp[0];
	for (int i = 0; i < N; i++) {
		if (result < dp[i]) {
			result = dp[i];
		}
	}
	
	cout << result;

	return 0;

}

