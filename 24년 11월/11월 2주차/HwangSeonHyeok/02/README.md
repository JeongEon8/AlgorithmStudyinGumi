# [백준 - G5] 2877. 4와 7

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

한자리 수가 2개 두자리수가 4개 3자리수가 8개가 있다 즉 n자리수면 $2^n$개의 4와 7로만 이루어진수가 있다.  
이진수로 바꾸고 4<7이므로 이진수의 왼쪽에서 두번째 자리부터 0이면 4 1이면 7을 출력한다.

```java
	String binary = Integer.toString(n+1, 2);
	String ans = "";
	for (int i = 1; i < binary.length(); i++) {
		if (binary.charAt(i) == '0') {
			ans += "4";
		} else {
			ans += "7";
		}
	}
```

## :black_nib: **Review**

요즘 랜덤 문제로 $2^n$과 관련된 문제가 꽤 많이 보인다.

## 📡**Link**

https://www.acmicpc.net/problem/2877
