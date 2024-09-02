#include <iostream>
#include <queue>

using namespace std;

int hand[10001] = { 0 };

int main(void) {
	int N, M;
	cin >> N >> M;

	for (int i = 1; i <= M; i++) {
		int h1, h2;
		cin >> h1 >> h2;

		hand[h1] = i;
		hand[h2] = i;
	}

	queue<int> q;
	for (int i = 1; i < 10001; i++) {
		if (hand[i] != 0) {
			q.push(hand[i]);
		}
	}

	for (int i = 1; i < N; i++) {
		q.push(q.front());
		q.pop();
	}

	cout << q.front() << endl;


	return 0;
}
