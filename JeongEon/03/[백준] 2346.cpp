// 2346. 풍선 터뜨리기

#include <iostream>
#include <deque>
#include <cmath>

using namespace std;

// 전역 변수
int N;
deque<pair<int, int>> dq;

int main(void) {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		int input;
		cin >> input;

		dq.push_back({ input, i });
	}

	while (dq.empty() == false) {
		int num = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();

		if (dq.empty() == false) {
			if (num > 0) {
				for (int i = 0; i < num - 1; i++) {
					dq.push_back(dq.front());
					dq.pop_front();
				}		
			}
			else {
				for (int i = 0; i < abs(num); i++) {
					dq.push_front(dq.back());
					dq.pop_back();
				}
			}
		}
	}
	return 0;
}
