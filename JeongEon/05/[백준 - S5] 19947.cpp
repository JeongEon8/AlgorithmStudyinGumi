#include <iostream> // cin, cout
#include <algorithm> // max
#include <cstring>	// memset

using namespace std;

int year[3] = { 1, 3, 5 };
double rate[3] = { 1.05, 1.2, 1.35 };
int H, Y;
int DP[11];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> H >> Y;

	DP[0] = H;

	for (int i = 1; i <= Y; i++) {
		for (int j = 0; j < 3; j++) {
			if (i - year[j] < 0) {
				continue;
			}
			DP[i] = max(DP[i], (int)(DP[i - year[j]] * rate[j]));
		}
	}

	cout << DP[Y] << '\n';

	return 0;
}
