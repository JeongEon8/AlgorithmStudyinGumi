# [백준 - S2] 32284. 오늘부터 우리는 (Me gustas tu) (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 애드 혹
- 해 구성하기

## ⏲️**Time Complexity**

$O(N*M)$

## :round_pushpin: **Logic**

타켓의 좌표 위치가 (a, b) 일때 행의 위치 a보다 작으면 남쪽(S)으로 크면 북쪽(N)으로 같을 경우 열의 위치 b보다 크거나 같을 경우 동쪽(E) 작을 경우 서쪽(W)으로 이동하게 구현했다.

```java
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i < a) {
					sb.append("S");
				}else if(i==a) {
					if(j <= b) {
						sb.append("E");
					}else {
						sb.append("W");
					}
				}else {
					sb.append("N");
				}
			}
			sb.append("\n");
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/32284
