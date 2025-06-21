# [백준 - S4] 1057. 토너먼트

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
선수들이 다음 라운드의 진출할때마다 (이번라운드에서의 번호 + 1) / 2의 번호로 번호를 할당받는다.  
즉 같은 번호를 할당 받을때가 a와 b가 경기하여 다음 라운드로 진출한 것이다. 
```java
int round = 0;
while (a != b) {
    a = (a + 1) / 2;
    b = (b + 1) / 2;
    round++;
}
System.out.println(round);
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/1057
