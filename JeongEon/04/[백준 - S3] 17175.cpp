#include <iostream> // cin, cout
 
using namespace std;

int N;
long long int DP[51];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	DP[0] = 1;
	DP[1] = 1;

	for (int i = 2; i <= N; i++) {
		DP[i] = DP[i - 1] + DP[i - 2] + 1;
	}

	cout << DP[N] % 1000000007;

	return 0;
}
