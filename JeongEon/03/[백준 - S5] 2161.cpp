#include <iostream>
#include <queue>

using namespace std;

// 입력 변수
int N; // 큐의 크기
queue<int> q;

// 초기화
void init() {
	for (int i = 0; i < N; i++) {
		q.push(i + 1);
	}
}

// 카드버리기
void throwTop() {
	cout << q.front() << " ";
	q.pop();
}

// 윗장을 아래로 옮긴다.
void topCardMove() {
	int tmp = q.front();
	q.pop();
	q.push(tmp);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 입력
	cin >> N;
	init();

	while (!q.empty()) {
		throwTop();
		if (!q.empty()) {
			topCardMove();
		}
	}

	return 0;
}
