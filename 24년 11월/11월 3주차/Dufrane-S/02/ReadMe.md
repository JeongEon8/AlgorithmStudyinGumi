# [백준 - S4] 10828. 스택

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

배열을 이용하여 실제 스택을 구현

```java
	if (word.equals("push")) {
				m = Integer.parseInt(st.nextToken());
			}
			if (word.equals("push")) {
				queue[idx] = m;
				idx++;
			} else if (word.equals("pop")) {
				if (idx == 0) {
					System.out.println(-1);
				} else {
					idx--;
					System.out.println(queue[idx]);
				}
			} else if (word.equals("size")) {
				System.out.println(idx);
			} else if (word.equals("empty")) {
				if (idx == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}else if (word.equals("top")) {
				if (idx == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue[idx - 1]);
				}
			}
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/10828
