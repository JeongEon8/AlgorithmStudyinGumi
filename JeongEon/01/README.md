# [백준 - 실버 5] 1193. 분수찾기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 분자는 홀수번째 대각선에서 아래로 증가, 짝수번째 대각선에서 위로 증가
2. 분모는 분자를 구한 후, i+1에서 분자를 뺀 
```cpp
	while (N > i) {
		N -= i;
		i++;
	}
```

## :black_nib: **Review**
- 규칙을 찾아야한다구...? 으악

## 📡 Link
https://www.acmicpc.net/problem/1193
