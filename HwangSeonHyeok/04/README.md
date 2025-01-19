# [백준 - S4] 1748. 수 이어 쓰기 1

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
1자리수가 나오는 개수부터 10부턴 2자리...이런 식으로 자릿수 개수를 세어주면된다.

```java
int ans = 0;
int tmp = 1;
int cnt = 1;
while (n >= tmp) {
	ans += ((Math.min(n, tmp * 10 - 1)) - tmp + 1) * cnt;
	tmp *= 10;
	cnt++;
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1748
