#include <iostream>
#include <cmath>

using namespace std;

// 전역변수
int N;
int stair[301];
int result[301];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	stair[0] = 0;
	for (int i = 1; i <= N; i++) {
		cin >> stair[i];
	}

	result[1] = stair[1];
	result[2] = stair[2] + stair[1];
	result[3] = max(stair[1] + stair[3], stair[2] + stair[3]);
	for (int i = 4; i <= N; i++) {
		result[i] = max(result[i - 3] + stair[i - 1] + stair[i], result[i - 2] + stair[i]);
	}

	cout << result[N] << '\n';

	return 0;
}
