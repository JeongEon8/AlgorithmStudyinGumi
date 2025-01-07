#include <iostream>

using namespace std;

// 방향벡터
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };

int arr[500][500];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, b;
	cin >> n >> m >> b;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}
	
	int result = 987654321;
	int resultHeight = 0;

	for(int e= 0; e <= 256; e++) {
		int removeTime = 0;
		int putTime = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > e) {
					removeTime += arr[i][j] - e;
				}
				else if (arr[i][j] < e) {
					putTime += e - arr[i][j];
				}
			}
		}

		if (removeTime + b >= putTime) {
			int sumTime = removeTime * 2 + putTime;
			if (result >= sumTime) {
				result = sumTime;
				resultHeight = e;
			}
		}
	}

	cout << result << " " << resultHeight << "\n";

	return 0;
}
