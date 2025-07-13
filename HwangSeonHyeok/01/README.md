# [백준 - S5] 33690. 포린드롬

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 수학
- 브루트포스 알고리즘
- 애드 혹

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
규칙처럼 P/10도 팰린드롬이 되는수는 111, 22222, 333333처럼 같은수가 반복되는 수만 존재한다. n보다 크지않은 같은 수가 반복되는 수를 모두 구하면 된다.
```java
for (int i = 1; i <= 9; i++) {
	long tmp = i;
	while (tmp <= n) {
		ans++;
		tmp = tmp * 10 + i;
	}

}
```

## :black_nib: **Review**  
포린드롬 수가 가능한 수들을 찾는데 오래걸렸다
## 📡**Link**
https://www.acmicpc.net/problem/33690
