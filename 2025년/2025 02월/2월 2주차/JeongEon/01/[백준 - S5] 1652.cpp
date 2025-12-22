#include<iostream>

using namespace std;

int N;
int arr[101][101];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	char k;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> k;
			if (k == '.') arr[i][j] = 1;
			else arr[i][j] = 0;
		}
	}

	int cnt_row = 0;
	int row = 0;
	int col = 0;
	int cnt_col = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (arr[i][j] == 1) {
				cnt_row++;
			}
			else {
				cnt_row = 0;
			}

			if (arr[j][i] == 1) {
				cnt_col++;
			}
			else {
				cnt_col = 0;
			}

			if (cnt_row == 2) {
				row++;
			}

			if (cnt_col == 2) {
				col++;
			}
		}

		cnt_row = 0;
		cnt_col = 0;
	}


	cout << row << " " << col << '\n';

	return 0;
}
