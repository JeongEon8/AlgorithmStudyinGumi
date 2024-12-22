# [백준 - S5] 32748. $f(A+B)$

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 구현
- 문자열

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
$f(0)$에서 $f(9)$의 값과 그 역을 미리 2개의 배열에 저장해두고 $f(A)$ $f(B)$의 역을 계산해 A와 B를 구하고 다시 $f(A+B)$를 구한다.

```java
String A = "";
String B = "";
for(int i = 0; i<split[0].length();i++) {
	char c = split[0].charAt(i);
	A+= Integer.toString(inverseF[c-'0']);
}
for(int i = 0; i<split[1].length();i++) {
	char c = split[1].charAt(i);
	B+= Integer.toString(inverseF[c-'0']);
}
int AB = Integer.parseInt(A)+Integer.parseInt(B);
String stringAB = Integer.toString(AB);
String ans = "";
for(int i = 0; i < stringAB.length();i++) {
	char c = stringAB.charAt(i);
	ans+= Integer.toString(f[c-'0']);
}
```

## :black_nib: **Review**
수학 문자열 문제라니..  

## 📡**Link**

https://www.acmicpc.net/problem/32748
