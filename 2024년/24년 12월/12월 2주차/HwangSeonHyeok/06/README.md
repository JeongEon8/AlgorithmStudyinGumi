# [백준 - S4] 2847. 게임을 만든 동준이

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

n-2부터 뒤에 숫자이상의 수라면 숫자를 줄여준다.  
숫자를 줄인 횟수가 답이다.
```java
	for (int i = n - 2; i >= 0; i--) {
		while (scores[i] >= scores[i + 1]) {
			scores[i]--;
			ans++;
		}
	}

```

## :black_nib: **Review**

while문이 아니라 그냥 빼는게 빠르고 코드도 더 짧았을듯하다..

## 📡**Link**

https://www.acmicpc.net/problem/2847
