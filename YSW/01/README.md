# [백준 - G5] 2866. 문자열 잘라내기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 이분 탐색
- 집합과 맵
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(C*R*logR)$

## :round_pushpin: **Logic**

이분 탐색으로 검사할 행의 위치를 결정하고 해당 행의 위치에서 문자열을 만들어서 Set에 문자열을 등록한다.
해당 행의 열들의 문자가 중복이 안되면 true 중복하면 false로 탐색 범위를 좁혀가면서 정답을 찾는다.

```java
	public static int search() {
		int start = 0;
		int end = R;
		while (start <= end) {
			int mid = (start + end) % 2 == 0 ? (start + end) / 2 : (start + end) / 2 + 1;

			if (check(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return start - 1;
	}

	public static boolean check(int mid) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < C; i++) {
			sb.setLength(0);
			for (int j = mid; j < R; j++) {
				sb.append(table[j].charAt(i));
			}
			if (wordsSet.contains(sb.toString())) {
				return false;
			}
			wordsSet.add(sb.toString());
		}
		return true;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2866
