#include <iostream>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	// 선언부
	int K;					// 이미 가지고 있는 랜선 개수
	int N;					// 필요한 랜선 개수
	long long num = 0;		// 만들어진 랜선 개수
	int LAN[10001];			// 이미 가지고 있는 랜선 길이
	long long max = 0;		// 가장 긴 랜선, 중앙값
	long long answer = 0;	// [정답] 자를 수 있는 최대 랜선 길이
	long long lower, upper;	// 이진 탐색을 위한 최소, 최대


	// 입력부
	cin >> K >> N;

	for (int i = 0; i < K; i++) {
		cin >> LAN[i];
		if (max < LAN[i]) {		// 가장 긴 랜선을 max에 저장
			max = LAN[i];
		}
	}

	// Binary Search
	lower = 1, upper = max;	// lower, upper 초기화

	while (lower <= upper) {
		num = 0;	// num 초기화
		max = (lower + upper) / 2;	// 중앙값 찾기
		for (int i = 0; i < K; i++) {	// 랜선의 개수 num에 저장
			num += LAN[i] / max;
		}

		if (num < N) {	// 랜선 개수가 적으면
			upper = max - 1;	// while 탈출을 위해 1 뺌
		}
		else {	// 랜선 개수가 많으면
			lower = max + 1;	// while 탈출을 위해 1 더함
			if (answer < max) {
				answer = max;
			}
		}
	}


	// 출력부
	cout << answer;


	return 0;
}
