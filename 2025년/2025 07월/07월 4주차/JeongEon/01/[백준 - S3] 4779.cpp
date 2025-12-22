#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int N;
vector<int> vec;
string bar = "";

void makeString() {
	int len = pow(3, N);
	for (int i = 0; i < len; i++) {
		bar += "-";
	}
}

void recursion(int cnt) {
	if (cnt == 0) {
		cout << bar << '\n';
		return;
	}

	int size = vec.size();
	for (int i = 0; i < size; i++) {
		int start = vec[i];
		int len = pow(3, cnt);
		int eraseStartpt = len / 3;
		int eraseEndpt = (len / 3) + (len / 3);

		for (int j = start + eraseStartpt; j < start + eraseEndpt; j++) {
			bar[j] = ' ';
		}
		vec.push_back(start + eraseEndpt);
	}
	recursion(cnt - 1);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	while (cin >> N) {
		bar = "";
		vec.clear();
		vec.push_back(0);

		makeString();
		recursion(N);
	}

	return 0;
}
