# [백준 - 실버 2] 2961. 도영이가 만든 맛있는 음식
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 쓴맛끼리는 더하고, 신맛끼리는 곱한다.
2. 쓴맛 합과 신맛 합의 차가 최소인 값을 업데이트 한다.
```cpp
void func(int cnt, int idx, long long s, long long b) {
    if (cnt >= 1 && abs(s - b) < Min) {
        Min = abs(s - b);
    }

    if (idx == n) {
        return;
    }

    func(cnt + 1, idx + 1, s * S[idx], b + B[idx]);
    func(cnt, idx + 1, s, b);
}
```

## :black_nib: **Review**
- 와 행복한 실버

## 📡 Link
https://www.acmicpc.net/problem/2961
