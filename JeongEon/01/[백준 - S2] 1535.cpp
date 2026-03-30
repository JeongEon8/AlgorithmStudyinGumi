#include <iostream>			// cin, cout

using namespace std;

int N;		// 사람수
int L[21];	// 체력( > 0)
int J[21];	// 기쁨

int max_joy;	// 최대 기쁨

void hello(int n, int life, int joy) {
	if (life >= 100) {
		return;
	}

	if (joy > max_joy) {
		max_joy = joy;
	}

	for (int i = n; i < N; i++) {
		hello(++n, life + L[i], joy + J[i]);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> L[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> J[i];
	}

	hello(0, 0, 0);

	cout << max_joy;

	return 0;
}
