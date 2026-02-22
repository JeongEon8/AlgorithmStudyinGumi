# [백준 - 실버 2] 19583.싸이버개강총회

## ⏰ **time**
6분

## :pushpin: **Algorithm**
맵

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 개강총회 시작 전에 입장한 사람들 체크하고
2. 그 사람들 중 종료 전에도 채팅을 친 사람이 있다면 카운트
```cpp
	while (cin >> timeInput >> nickname) {
		if (timeInput <= S) {
			nicknames[nickname] = 1;
		}
		else if (timeInput >= E && timeInput <= Q) {
			if (nicknames[nickname] == 1) {
				nicknames[nickname] = 2;
				result++;
			}
		}
	}
```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/19583](https://www.acmicpc.net/problem/19583)
