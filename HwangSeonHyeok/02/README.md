# [백준 - S5] 32172. 현권이와 신기한 수열

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
음수이거나 중복된 값이면 연산이 다르므로 중복 값을 체크하기위해 set에다 저장하면서 계산한다.

```java
set.add(ans);
for (int i = 1; i <= n; i++) {
	int tmp = ans;
	tmp -= i;
	if (tmp < 0 || set.contains(tmp)) {
		ans += i;
	} else {
		ans = tmp;
	}
	set.add(ans);
}
System.out.println(ans);
```

## :black_nib: **Review**
수열 식이 나오면 일단 겁이난다
## 📡**Link**

https://www.acmicpc.net/problem/32172
