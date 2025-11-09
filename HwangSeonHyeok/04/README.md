# [백준 - S5] 14912. 숫자 빈도수

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
1에서 n까지 각 자릿수에서 digit이 나왔는지 직접 찾는다.
```java
int ans = 0;
for (int i = 1; i <= n; i++) {
    int tmp = i;
    while (tmp > 0) {
        if (tmp % 10 == d) {
            ans++;
        }
        tmp /= 10;
    }
}
```  
## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/14912