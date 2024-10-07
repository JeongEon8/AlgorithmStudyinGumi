# [백준 - 실버 5] 10867. 중복 빼고 정렬하기
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
map

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. map을 통해 중복 수 추가 불가능!
   ```cpp
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		m.insert({ input, 1 });
	}
   ```

## :black_nib: **Review**
- 맵 좋아

## 📡 Link
https://www.acmicpc.net/problem/10867
