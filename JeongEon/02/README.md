# [백준 - 골드 4] 1043. 거짓말
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현, 완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 파티에 진실을 알고 있는 사람이 있다면 다시 첫번째 파티부터 진실을 아는 사람이 있는지 확인하기
2. 진실을 알거나, 나중에 알수도 있는 사람이 없다면 cnt++
```cpp
	for (int i = 0; i < M; i++) {
		bool flag = false;
		for (int j = 0; j < member[i].size(); j++) {
			if (people[member[i][j]]) {
				flag = true;
				party[i] = true;
				break;
			}
		}

		if (!flag) {
			continue;
		}

		for (int j = 0; j < member[i].size(); j++) {
			if (people[member[i][j]] == false) {
				people[member[i][j]] = true;
				i = -1;
		}
	}
```

## :black_nib: **Review**
- 이게 시간초과가 안나잖아..?
- 유니온 파인드가 정설인거 같은데.. 유니온 파인드 공부해야봐야겠다.

## 📡 Link
https://www.acmicpc.net/problem/1043
