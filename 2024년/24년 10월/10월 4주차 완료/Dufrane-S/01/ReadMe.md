# [백준 - S5] 1436. 영화감독 숌

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 브루트포스

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1씩 증가시키면서 666을 찾아준다.

```java
	while(true) {
			String test=Integer.toString(num);
			if(test.contains("666") && answer==n) {break;
			}else if(test.contains("666")) {
				answer++;
				num++;
			}else {
				num++;
			}
		}
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/1436
