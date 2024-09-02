#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<vector<int>>box = vector<vector<int>>(4, vector<int>(8, 0));//2가 오른쪽 6이 왼쪽
vector<bool>done = vector<bool>(4, false);
void rotate(int num, int count) {

	done[num] = true;
	if (num + 1 < 4 && box[num + 1][6] != box[num][2] && done[num + 1] == false) {//오른쪽
		rotate(num + 1, -count);
	}
	if (num - 1 >= 0 && box[num - 1][2] != box[num][6] && done[num - 1] == false) {//왼쪽
		rotate(num - 1, -count);
	}
	if (count == 1) {
		int temp = box[num][7];
		for (int i = 7; i > 0 ; i--) {
			box[num][i] = box[num][i - 1];
		}
		box[num][0] = temp;
	}
	else if (count == -1) {
		int temp = box[num][0];
		for (int i = 0; i < 7; i++) {
			box[num][i] = box[num][i + 1];
		}
		box[num][7] = temp;
	}
}


int main() {


	for (int i = 0; i < 4; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < 8; j++) {
			box[i][j] = s[j] - '0';
		}
	}

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		a--;
		rotate(a, b);
		for (int k = 0; k < 4; k++) {
			done[k] = false;
		}
	}
	int answer = 0;
	for (int i = 0; i < 4; i++) {
		if (box[i][0] == 1) {
			answer = answer + pow(2, i);
		}
	}
	cout << answer;
}
