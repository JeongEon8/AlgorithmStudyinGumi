#include <iostream>				// cin, cout
#include <vector>				// vector
#include <algorithm>			// sort
#include <cmath>				// max

using namespace std;

int N;
vector<pair<int, int>> wire;
int dp[100];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	int A, B;
	for (int i = 0; i < N; i++) {
		cin >> A >> B;
		wire.push_back({ A, B });
	}

	sort(wire.begin(), wire.end());

	for (int i = 0; i < N; i++) {
		int tmp = 0;
		for (int j = 0; j < i; j++) {
			if (wire[i].second > wire[j].second) {
				tmp = max(tmp, dp[j]);
			}
		}
		dp[i] = tmp + 1;
	}

	int result = 0;
	for (int i = 0; i < N; i++) {
		result = max(result, dp[i]);
	}

	cout << N - result;

	return 0;
}
