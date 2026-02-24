# [백준 - 실버 2] 1254. 팰린드롬 만들기

## ⏰ **time**
15분

## :pushpin: **Algorithm**
팰린드롬

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 문자열 길이에서 맨 앞과 맨 뒤를 하나씩 빼고 더하면서 다를 때
2. 문자열에서 팰린드롬 접미사의 길이를 뺀 만큼 길어진 값
```cpp
bool function(int L, int R) {
	while (L < R) {
		if (S[L] != S[R]) return 0;
		L++, R--;
	}
	return 1;

```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/1254](https://www.acmicpc.net/problem/1254)
