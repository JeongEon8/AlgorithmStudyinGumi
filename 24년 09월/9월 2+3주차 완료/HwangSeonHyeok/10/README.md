# [백준 - s5] 30993. 자동차 주차

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 조합론

## :round_pushpin: **Logic**

팩토리얼을 미리 구해두고 조합을 계산한다.

```java
int n = Integer.parseInt(split[0]);
int a = Integer.parseInt(split[1]);
int b = Integer.parseInt(split[2]);
int c = Integer.parseInt(split[3]);
long ans = fact[n] / fact[a] / fact[b] / fact[c];
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/30993
