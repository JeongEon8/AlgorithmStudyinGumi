// 백준
// 실버 5
// 2167. 2차원 배열의 합

#include <iostream>

using namespace std;

int main(void) {
	int N, M;
	cin >> N >> M;

	int arr[301][301];
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> arr[i][j];
		}
	}

	int K;
	cin >> K;

	for (int k = 0; k < K; k++) {
		int x1, y1;
		int x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;

		int sum = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				sum += arr[i][j];
			}
		}

		cout << sum << endl;
	}

	return 0;
}
