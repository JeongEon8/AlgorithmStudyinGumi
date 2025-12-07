# [백준 - S5] 2622. 삼각형만들기 

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
삼각형의 조건은 가장 긴 변이 다른 두변의 합보다 작아야한다.  
즉 (n+1)/2보다 작고 가장 긴변이기 위해 (n+2)/3이상이어야한다.  가장 큰 변을 기준으로 중간변이 될 수 있는 갯수를 세어준다.
```java
for (int i = (n + 2) / 3; i < (n + 1) / 2; i++) {
    int maxMid = i;
    int minMid = (n - i + 1) / 2;
    if (maxMid >= minMid) {
        ans += (maxMid - minMid + 1);
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2622