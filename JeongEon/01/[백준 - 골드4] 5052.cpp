#include <iostream>
#include <string>
#include <cstring>

using namespace std;

// 전역변수
int t;
int n;
int arr[100001][11];
bool finish[100001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;

	for (int tc = 1; tc <= t; tc++) {
		cin >> n;

		int flag = 0;
		int cnt = 0;
		memset(arr, 0, sizeof(arr));
		memset(finish, 0, sizeof(finish));
		for (int i = 1; i <= n; i++) {
			string input;
			cin >> input;

			if (flag == 1) {
				continue;
			}

			int before = 0;
			for (char c : input) {
				if (arr[before][c - '0'] == 0) {
					arr[before][c - '0'] = ++cnt;
				}

				before = arr[before][c - '0'];

				if (finish[before]) {
					flag = 1;
					break;
				}
			}
			if (before != cnt) {
				flag = 1;
			}

			finish[before] = 1;
		}

		if (flag == 0) {
			cout << "YES" << '\n';
		}
		else {
			cout << "NO" << '\n';
		}
	}

	return 0;
}
