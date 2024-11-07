#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

int arr[201][201][201];

int main(void) {
	int N, L;
	cin >> N >> L;

	priority_queue<int> q;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		q.push(-input);
	}

	while (!q.empty()) {
		if (L >= abs(q.top())) {
			L += 1;
			q.pop();
		}
		else {
			break;
		}
	}

	cout << L << '\n';

	return 0;
}
