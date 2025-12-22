# [백준 - S5] 24228. 젓가락

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 비둘기집 원리

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
n+1개를 뽑으면 무조건 첫번째 쌍이 맞춰진다.  
이후엔 그 맞춰진쌍만 연속으로 2*(r-1)번 뽑는 경우가 최악이다. 즉 $n+1+2*r-2 = n + 2*r - 1$
```java
long n = Long.parseLong(st.nextToken());
long r = Long.parseLong(st.nextToken());
System.out.println(n + 2 * r - 1);
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/24228