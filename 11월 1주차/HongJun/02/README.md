# [백준 - S5] 11723. 집합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 비트마스킹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 각 조건을 비트마스킹으로 표시해서 품
```
S |= (1<<x);    // 추가 = OR 연산
S &= ~(1<<x);   // 제거 = NOT 연산 + AND 연산
if (S & (1<<x)) // check
if (S & (1<<x)) // toggle
S = (1<<21) - 1;// all = 1~20으로 바꾸기
S = 0;          // 비우기
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/11723