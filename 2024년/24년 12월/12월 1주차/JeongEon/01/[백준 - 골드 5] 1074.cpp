#include <iostream>
#include <cmath>

using namespace std;

// 전역변수
int N; 
int r, c;
int result;

void divideNconquer(int x, int y, int size) {
	if (x == c && y == r) {
		cout << result << "\n";
		return;
	}
	else if (c < x + size && r < y + size && c >= x && r >= y) {
		//찾으려는 열과 행이 4분면안에 있을 경우
		divideNconquer(x, y, size / 2);
		divideNconquer(x + size / 2, y, size / 2);
		divideNconquer(x, y + size / 2, size / 2);
		divideNconquer(x + size / 2, y + size / 2, size / 2);
	}
	else { // 없다면 숫자 카운트 -> 정사각형 넓이
		result += size * size;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> r >> c;

	result = 0;
	divideNconquer(0, 0, pow(2, N));

	return 0;
}
