# [백준 - S4] 25379. 피하자 (Nomal)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

최소한으로 움직여서 홀수 짝수를 한쪽으로 나누는 문제 같았다. 그래서 짝수를 오른쪽으로 밀었을 때랑 왼쪽으로 밀었을 때 더 적게 나오는 경우를 출력했다.

```java
		// 0 짝수를 전부 왼쪽
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				if (currentIndex != -1) {
					sum += count;
				}
			} else {
				if (currentIndex == -1) {
					currentIndex = i;
				}
				count++;
			}
		}
		min = sum;
		sum = 0;
		count = 0;

		// 0 짝수를 전부 오른쪽
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				if (currentIndex != -1) {
					sum += count;
				}
			} else {
				if (currentIndex == -1) {
					currentIndex = i;
				}
				count++;
			}
		}

		if (min > sum) {
			min = sum;
		}
```

## :black_nib: **Review**

그리디라 그런가 어떻게 풀지 생각하고 구현하는데 시간이 좀 걸렸던거 같다. 그리고 서브태스크 문제였는데 100점 안나오고 50점 나왔다. 개선점이 필요한거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/25379
