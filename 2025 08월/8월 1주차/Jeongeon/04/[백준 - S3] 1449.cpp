#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N;                // 물이 새는 곳의 개수
	int L;                // 테이프의 길이
	int location[1000];   // 물이 새는 곳의 위치
	int start;            // 각 테이프의 시작 위치
	int tape = 0;         // 필요한 테이프의 개수

	cin >> N >> L;

	for (int i = 0; i < N; i++) {
		cin >> location[i];
	}

	// 물이 새는 위치를 오름차순 정렬
	sort(location, location + N);

	// 시작 위치를 맨 처음 누수 위치로 설정
	start = location[0];

	for (int i = 1; i < N; i++) {
		// 테이프의 길이가 모자라게 되면
		if (L <= location[i] - start) {
			// 해당 지점 전까지 테이프를 사용했으므로 값 증가
			tape++;
			// 테이프가 부족한 지점부터 시작위치 재설정
			start = location[i];
		}
	}

	// for문에서 마지막에 붙인 테이프는 세지 않았으므로 + 1
	cout << tape + 1;

	return 0;
}
