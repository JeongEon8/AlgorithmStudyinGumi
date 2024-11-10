# [백준 - S5] 1343. 폴리오미노

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각각의 연속된 X의 수를 카운트하고 4개이상의 연속된 X면 일단 AAAA를 넣고 2개남을때만 BB이다. 단 홀수인 경우 채울 수 없다.

```java
	static void fillBoard(int cnt) {
		if (cnt % 2 == 1) {
			fail = true;
			return;
		}
		int A = cnt / 4;
		for (int j = 0; j < A; j++) {
			sb.append("AAAA");
		}
		if (cnt % 4 == 2) {
			sb.append("BB");
		}

	}

	for (int i = 0; i < board.length(); i++) {
		if (board.charAt(i) == 'X') {
			cnt++;
		} else {
			fillBoard(cnt);
			cnt = 0;
			if (fail)
				break;
			sb.append(".");

		}
	}
	fillBoard(cnt);

```

## :black_nib: **Review**

dfs에 메모이제이션을 결합한 문제

## 📡**Link**

https://www.acmicpc.net/problem/1937
