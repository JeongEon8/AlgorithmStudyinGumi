# [백준 - G5] 33705. 마스코트 정하기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 애드 혹
- 누적 합

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1번 후보에게 투표한 표의 개수를 누적합 배열에 저장한다.
전체 투표 중 1번 후보의 득표가 과반수 이상이면, 추가 행동 없이 조건을 만족하므로 최소 행동 횟수는 0이다.
과반수가 아니라면, 누적합 배열을 이용해 가능한 모든 구간을 검사한다. 앞쪽 구간(i까지)에서 1번 후보 득표가 과반이거나 뒤쪽 구간(i 길이)의 득표가 과반이면 조건 충족
조건을 만족하는 구간이 있다면 최소 행동 횟수는 1, 없다면 2가 된다.

```java
		for (int i = 1; i <= N; i++) {
			int vote = Integer.parseInt(inputs[i - 1]);
			voteOneCount[i] = voteOneCount[i - 1] + (vote == 1 ? 1 : 0);
		}

		int result;
		if (voteOneCount[N] * 2 >= N) {
			result = 0;
		} else {
			result = 2;
			for (int i = 1; i <= N; i++) {
				if (voteOneCount[i] * 2 >= i || (voteOneCount[N] - voteOneCount[N - i]) * 2 >= i) {
					result = 1;
					break;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/33705
