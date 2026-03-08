#include <iostream> // cin, cout

using namespace std;

int D, K, A, B;
pair<int, int> DP[31];

void makeDP(int d) {
	for (int k = 3; k <= d; k++) {
		DP[k] = { DP[k - 2].first + DP[k - 1].first, DP[k - 2].second + DP[k - 1].second };
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> D >> K;

	DP[1] = pair<int, int>{ 1, 0 };
	DP[2] = pair<int, int>{ 0, 1 };
	makeDP(D);

	B = K / DP[D].second;
	A = 1;
	for (; B > A; B--) {
		for (A = 1; A < B; A++) {
			int calculate = DP[D].first * A + DP[D].second * B;
			if (calculate == K) {
				cout << A << '\n' << B << '\n';
				return 0;
			}
			else if (calculate > K) {
				break;
			}
		}
	}

	return 0;
}
