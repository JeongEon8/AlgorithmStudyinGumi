# [백준 - S5] 24313. 알고즘 수업 - 접근적 표기1

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- f(n) = a1*n + a0 함수에서 n0이 주어진다.
- f(n) <= c*g(n)을 만족하는 n >= n0
- n0를 넣었을 떄 무조건 조건이 만족해야 한다.
- 조건문에서 a1*n0 + a0 <= c*n0가 참이어야 한다.
- 그리고 a1 <= c도 만족해야 a가 음수일 때도 조건을 만족하게 된다.
```c++
    if (a1*n0 + a0 <= c*n0 && a1 <= c)
        cout << 1;
    else
        cout << 0;
```


## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/24313