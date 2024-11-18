# [백준 - S4] 10845. 큐

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

배열을 이용하여 실제 큐를 구현

```java
	if (word.equals("push")) {
				queue[ridx] = m;
				ridx++;
			} else if (word.equals("pop")) {
				if (ridx == fidx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[fidx]);
					fidx++;
				}
			} else if (word.equals("size")) {
				System.out.println(ridx-fidx);
			} else if (word.equals("empty")) {
				if (ridx == fidx) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (word.equals("front")) {
				if (ridx == fidx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[fidx]);
				}
			} else if (word.equals("back")) {
				if (fidx == ridx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[ridx-1]);
				}
			}
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/108245
