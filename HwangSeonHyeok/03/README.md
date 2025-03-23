# [백준 - S5] 32622. 카드 뒤집기 게임

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
첫번째 카드부터 N번째까지 뒤집을 수 있으므로 현제 연속인 카드 장수, 자신과 종류가 다른 직전 종류의 연속수만큼의 길이를 만들 수 있다.
```java
for (int i = 0; i < n; i++) {
	if (split[i].charAt(0) == '0') {
		if (!isZero) {
			isZero = true;
			ans = Math.max(ans, zero + one);
			zero = 0;
		}
		zero++;
	} else {
		if (isZero) {
			isZero = false;
			ans = Math.max(ans, zero + one);
			one = 0;
		}
		one++;
	}
}
ans = Math.max(ans, zero + one);
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/32622
