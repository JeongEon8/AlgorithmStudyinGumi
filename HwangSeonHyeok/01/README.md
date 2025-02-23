# [백준 - S5] 2828. 사과 담기 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
사과가 바구니 밖에서 떨어지는경우 바구니 끝에 닿을수 있을정도만 바구니를 이동시키고 이동한 거리를 더해준다.

```java
for (int i = 0; i < j; i++) {
	int apple = Integer.parseInt(in.readLine());
	if (current - m >= apple) {
		ans += current - m - apple + 1;
		current = m + apple - 1;
	} else if (apple > current) {
		ans += apple - current;
		current = apple;
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2828
