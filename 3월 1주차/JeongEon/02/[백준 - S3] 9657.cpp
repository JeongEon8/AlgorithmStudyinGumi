#include <iostream> // cin, cout

using namespace std;

int N;
int DP[1001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	
	DP[1] = 1;
	DP[2] = 0;
	DP[3] = 1;
	DP[4] = 1;

	for (int i = 5; i <= N; i++) {
		if (DP[i - 1] == 1 && DP[i - 3] == 1 && DP[i - 4] == 1) {
			DP[i] = 0;
		}
		else {
			DP[i] = 1;
		}
	}

	if (DP[N] == 1) {
		cout << "SK" << '\n';
	}
	else {
		cout << "CY" << '\n';
	}


	return 0;
}
