#include<iostream>

using namespace std;

int main(void) {
	int N;
	int cnt = 0;

	cin >> N;

	if (N < 10) {
		cout << N;
		return 0;
	}

	for (int i = 1; i <= N; i *= 10) {
		cnt += N - i + 1;
	}

	cout << cnt;

	return 0;
}
