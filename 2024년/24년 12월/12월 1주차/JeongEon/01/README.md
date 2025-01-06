# [백준 - 골드 5] 1074. Z
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
분할정복

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 구간을 반으로 쪼개가며 현재 범위가 내가 찾는 위치인지 확인한다.
2. 아니라면 현재 사이즈의 제곱을 더한다.
3. 맞다면 현재 result를 출력한다.
   ```cpp
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
   ```

## :black_nib: **Review**
- 지그제그지그제그....

## 📡 Link
https://www.acmicpc.net/problem/1074
