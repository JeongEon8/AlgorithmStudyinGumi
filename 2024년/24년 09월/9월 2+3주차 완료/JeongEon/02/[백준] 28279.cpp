#include <iostream>
#include <deque>

using namespace std;

int input;
int N;
int num;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N;

	deque<int> dq;
	for (int i = 0; i < N; i++) {
		cin >> input;

		if (input == 1) {
			cin >> num;
			dq.push_front(num);
		}
		else if (input == 2) {
			cin >> num;
			dq.push_back(num);
		}
		else if (input == 3) {
			if (dq.size () > 0) {
				cout << dq.front() << '\n';
				dq.pop_front();
			}
			else {
				cout << -1 << '\n';
			}
		}
		else if (input == 4) {
			if (dq.size() > 0) {
				cout << dq.back() << '\n';
				dq.pop_back();
			}
			else {
				cout << -1 << '\n';
			}
		}
		else if (input == 5) {
			cout << dq.size() << '\n';
		}
		else if (input == 6) {
			if (dq.empty()) {
				cout << 1 << '\n';
			}
			else {
				cout << 0 << '\n';
			}
		}
		else if (input == 7) {
			if (dq.size() > 0) {
				cout << dq.front() << '\n';
			}
			else {
				cout << -1 << '\n';
			}
		}
		else if (input == 8) {
			if (dq.size() > 0) {
				cout << dq.back() << '\n';
			}
			else {
				cout << -1 << '\n';
			}
		}
	}

	return 0;
}

