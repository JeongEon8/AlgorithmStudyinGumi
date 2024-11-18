#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	vector<int> tips;
	for (int i = 0; i < N; i++) {
		int tip;
		cin >> tip;
		tips.push_back(tip);
	}

	sort(tips.begin(), tips.end(), greater<>());
	
	long long  sum = 0;
	for (int i = 0; i < N; i++) {
		int money = tips[i] - ((i + 1) - 1);
		if (money <= 0) {
			money = 0;
		}

		sum += money;
	}

	cout << sum << endl;

	return 0;
}
