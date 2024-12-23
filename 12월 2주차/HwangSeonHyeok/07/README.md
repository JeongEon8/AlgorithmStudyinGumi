# [백준 - G5] 23083. 꿀벌 승연이

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**
구멍을 -1로 표기해둔다. 아래칸이나 오른쪽칸은 현제 칸에 영향을 줄 수 없으므로 세로 방향으로 돌며서 자신칸에 올 수 있는 칸에 도착하는 방법의 개수를 더해준다.  
홀수열과 짝수 열이 다르고 구멍에대한 처리까지 해준다.
```java
	for (int i = 0; i < k; i++) {
		split = in.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		house[x][y] = -1;
	}
	house[1][1] = 1;
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (house[j][i] == -1)
				continue;
			house[j][i] += Math.max(0, house[j][i - 1]);
			house[j][i] += Math.max(0, house[j - 1][i]);
			house[j][i] %= mod;
			house[j][i] += (i % 2 == 0) ? Math.max(0, house[j + 1][i - 1]) : Math.max(0, house[j - 1][i - 1]);
			house[j][i] %= mod;
		}
	}

```

## :black_nib: **Review**
완전히 같은 문제를 어디서 풀어본거같은데..


## 📡**Link**

https://www.acmicpc.net/problem/23083
