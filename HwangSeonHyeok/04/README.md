# [백준 - S2] 2777. 숫자 놀이

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
한 자릿수의 곱으로 만들어야하므로 큰 수부터 나눌 수 있는 수로 나눠나가면된다.
```java
	int ans = 0;
	while (n >= 10) {
		n = div(n);
		ans++;
	}
	if (n == -1) {
		ans = -1;
	} else {
		ans++;
	}

```

## :black_nib: **Review**
한 자릿수인 케이스에서 답이 1이라니..  
2 아닌가..?

## 📡**Link**

https://www.acmicpc.net/problem/2777
