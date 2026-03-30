#include <iostream>			// cin, cout

using namespace std;

int N;				// 수열의 길이
int num[100001];	// 수열
int max_cnt;		// 최대 길이

void isBigger(int n, int cnt, int flag);
void isSmaller(int n, int cnt, int flag);

void isBigger(int n, int cnt, int flag) {
	max_cnt = max_cnt < cnt ? cnt : max_cnt;
	if (n >= N - 1) {
		return;
	}

	if (num[n] < num[n + 1]) {
		isBigger(n + 1, cnt + 1, n + 1);
	}
	else if (num[n] == num[n + 1]) {
		isBigger(n + 1, cnt + 1, flag);
	}
	else {
		isSmaller(n + 1, ((n+1) - flag) + 1, n + 1);
	}
}

void isSmaller(int n, int cnt, int flag) {
	max_cnt = max_cnt < cnt ? cnt : max_cnt;
	if (n >= N - 1) {
		return;
	}

	if (num[n] > num[n + 1]) {
		isSmaller(n + 1, cnt + 1, n + 1);
	}
	else if (num[n] == num[n + 1]) {
		isSmaller(n + 1, cnt + 1, flag);
	}
	else {
		isBigger(n + 1, ((n + 1) - flag) + 1, n + 1);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	isBigger(0, 1, 0);

	cout << max_cnt;

	return 0;
}

