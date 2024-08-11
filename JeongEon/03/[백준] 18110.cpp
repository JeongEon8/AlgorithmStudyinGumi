// 백준
// 실버 5
// 18110. solved.ac

#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	if (n == 0) {
		cout << 0;
		return 0;
	}
	
	vector<int> level;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;
		level.push_back(input);
	}

	sort(level.begin(), level.end());

	double start = round(n * 0.15);
	double sum = 0;
	for (int i = start; i < n - start; i++) {
		sum += level[i];
	}

	int result = round(sum / (n - start * 2));
	cout << result << endl;

	return 0;
}
