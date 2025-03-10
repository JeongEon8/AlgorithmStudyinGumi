# [백준 - 실버 5] 1094. 막대기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
수학

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 절반으로 자른 막대를 모두 합한다
```cpp
while (X>0) {
    if (X % 2 == 1) {
        ans++;
    }
    X /= 2;
}
```

## :black_nib: **Review**
- 막대기를 잘라~ 근데, 문제가 이해가 안되서.. 오래 걸리ㄴ..

## 📡 Link
https://www.acmicpc.net/problem/1094
