#include <iostream>			// cin, cout

using namespace std;

int T;				// 테스트 케이스 개수
int n;				// 정수
long long DP[1000001];	// 방법수
int top;			// 역대 큰 수

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	DP[1] = 1;
	DP[2] = 2;
	DP[3] = 4;
	top = 3;

	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> n;

		if (n <= top) {
			cout << DP[n] % 1000000009 << '\n';
		}
		else {
			for (int i = top + 1; i <= n; i++) {
				DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3])% 1000000009 ;
			}
			top = n;
			cout << DP[n] % 1000000009 << '\n';
		}
	}

	return 0;
}

