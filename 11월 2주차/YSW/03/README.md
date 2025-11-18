# [백준 - S5] 1789. 수들의 합 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(√S)$

## :round_pushpin: **Logic**

1 + 2 + 3 + ... + n = S를 구하는 문제이기 때문에 반복문에서 count를 1씩 증가시키며 sum에 더한다. sum이 S보다 커지면 반복 종료 마지막으로 더한 수 때문에 합이 S를 초과했으므로, N의 최대값으로는 count - 1을 출력한다.

```java
		while (true) {
			if (sum > S) {
				break;
			}
			sum += ++count;
		}

		System.out.println(count - 1);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1789
