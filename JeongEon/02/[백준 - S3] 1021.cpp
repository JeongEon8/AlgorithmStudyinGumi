#include <iostream>
#include <deque>
#include <cmath>

using namespace std;

// 입력 변수
int N; // 큐의 크기
int M; // 뽑아내려는 수의 개수
deque<int> dq; // 회전하는 큐
int findNum; // 뽑아내려고 하는 수
int cnt = 0; // 연산 횟수

// 초기화
void init() {
	for (int i = 0; i < N; i++) {
		dq.push_back(i+1);
	}
}

// 첫번째 원소 뽑기
void pop() {
	dq.pop_front();
}

// 왼쪽으로 한 칸 이동
void left_function() {
	int tmp = dq.front();
	dq.pop_front();
	dq.push_back(tmp);
	cnt++;
}

// 오른쪽으로 한 칸 이동
void right_function() {
	int tmp = dq.back();
	dq.pop_back();
	dq.push_front(tmp);
	cnt++;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 입력
	cin >> N >> M;
	init();

	while(M--) {
		cin >> findNum;

		// 로직
		int idx = 0;
		for (int i = 0; i < dq.size(); i++) {
			if (dq[i] == findNum) {
				idx = i;
				break;
			}
		}

		// 찾으려는 수가 뒷번호에 가까우면?
		if (idx > dq.size()/2) {
			while (dq.front() != findNum) {
				right_function();
			}
		}
		// 찾으려는 수가 앞번호에 가까우면?
		else if (idx <= dq.size() / 2) {
			while (dq.front() != findNum) {
				left_function();
			}
		}
		else {
			cout << dq.front() << " " << dq.back() << " " << findNum << endl;
			cout << "예외를 찾았다!" << endl;
			return 0;
		}

		pop();
	}	

	// 출력
	cout << cnt << '\n';

	return 0;
}
