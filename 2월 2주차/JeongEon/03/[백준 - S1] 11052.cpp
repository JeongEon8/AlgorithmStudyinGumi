#include <iostream>		// cin, cout

using namespace std;

int N;
int P[1001];
int DP[1001];

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	
	for (int i = 1; i <= N; i++) {
		cin >> P[i];
	}

	DP[0] = P[0] = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			DP[i] = DP[i] < DP[i - j] + P[j] ? DP[i - j] + P[j] : DP[i];
		}
	}

	cout << DP[N];

	return 0;
}
