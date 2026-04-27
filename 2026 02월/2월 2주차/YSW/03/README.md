# [백준 - S2] 15787. 기차가 어둠을 헤치고 은하수를 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 비트마스킹

## ⏲️**Time Complexity**

$O(N + M)$

## :round_pushpin: **Logic**

각 기차의 좌석 상태를 하나의 정수(long) 비트마스크로 표현하고, 명령에 따라 비트 연산으로 좌석을 추가/제거/이동한 뒤, 최종 상태의 서로 다른 개수를 구하는 문제입니다.
1번 명령일때는 해당 비트를 1로 설정해주고 2일때는 0으로 3번일때는 비트를 왼쪽으로 밀어주고 좌석 범위를 벗어나는 비트는 filter로 제거해줍니다. 4번일때는 비트를 오른쪽으로 밀어주고 좌석범위를 벗어나는 비트는 filter로 제거해줍니다.
모든 명령을 처리한 뒤, 각 기차의 최종 상태를 HashSet에 저장하여 서로 다른 상태의 개수를 출력합니다.

```java
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int trainIndex = Integer.parseInt(st.nextToken()) - 1;
			if (command == 1 || command == 2) {
				int seatNum = Integer.parseInt(st.nextToken());

				if (command == 1) {
					trains[trainIndex] |= (1 << seatNum);
				} else {
					trains[trainIndex] &= ~(1 << seatNum);
				}
			} else {
				if (command == 3) {
					trains[trainIndex] = (trains[trainIndex] << 1) & filter;
				} else {
					trains[trainIndex] = (trains[trainIndex] >> 1) & filter;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			hashSet.add(trains[i]);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15787