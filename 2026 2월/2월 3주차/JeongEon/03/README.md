# [백준 - 실버 3] 1213.팰린드롬 만들기

## ⏰ **time**
28분

## :pushpin: **Algorithm**
팰린드롬, 그리디

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 각 문자열의 길이 만큼 뒤로 붙여준다!
2. 그 후 두 문자열이 같으면 무한! 아니면 0
```cpp
	string make1 = "";
	for (int i = 0; i < len2; i++) {
		make1 += str1;
	}

	string make2 = "";
	for (int i = 0; i < len1; i++) {
		make2 += str2;
	}
```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/12871](https://www.acmicpc.net/problem/12871)
