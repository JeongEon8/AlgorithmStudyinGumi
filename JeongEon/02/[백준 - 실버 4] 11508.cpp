#include <iostream>
#include <deque>
#include <algorithm>

using namespace std;

int main(void) {
	int N;
	cin >> N;
	
	deque<int> dq;
	for (int i = 0; i < N; i++) {
		int price;
		cin >> price;
		dq.push_back(price);
	}

	sort(dq.begin(), dq.end(), greater<>());

	long long result = 0;
	while (!dq.empty()) {
		if (dq.size() >= 3) {
			result += dq.front();
			dq.pop_front();
			result += dq.front();
			dq.pop_front();
			dq.pop_front();
		}
		else {
			result += dq.front();
			dq.pop_front();
		}
	}

	cout << result << endl;

	return 0;
}
