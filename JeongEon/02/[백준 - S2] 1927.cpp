#include <iostream>
#include <queue>

using namespace std;

int N;

priority_queue<int, vector<int>, greater<>> pq;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;

		if (input == 0) {
			if (pq.empty()) {
				cout << 0 << '\n';
			}
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		}
		else {
			pq.push(input);
		}
	}

	return 0;
}
