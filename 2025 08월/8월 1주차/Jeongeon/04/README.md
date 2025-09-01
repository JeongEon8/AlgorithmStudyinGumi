# [백준 - 실버 3] 1449. 수리공 항승

## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 시작점과 다음 시작점 사이의 길이를 구해서 테이프 길이에서 빼!
2. 만약 그거보다 커지면 테이프 개수를 더해!
```cpp
	for (int i = 1; i < N; i++) {
		// 테이프의 길이가 모자라게 되면
		if (L <= location[i] - start) {
			// 해당 지점 전까지 테이프를 사용했으므로 값 증가
			tape++;
			// 테이프가 부족한 지점부터 시작위치 재설정
			start = location[i];
		}
	}
```

## :black_nib: **Review**
- 냐옹
  
## 📡 Link
https://www.acmicpc.net/problem/1449
