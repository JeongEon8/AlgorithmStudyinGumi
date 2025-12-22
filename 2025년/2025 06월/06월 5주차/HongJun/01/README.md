# [백준 - S4] 2839. 설탕 배달

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 그리디, DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
DP 테이블에 설탕 키로당 가져갈 수 있는 개수의 최솟값을 계산해서 추가해준다.
그리고 N번째 테이블의 값을 출력하면 된다.
```python
    if tmp1 != -1 and tmp2 != -1:
        dp[i] = min(tmp1, tmp2) + 1
    elif tmp1 != -1:
        dp[i] = tmp1 + 1
    elif tmp2 != -1:
        dp[i] = tmp2 + 1
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/2839
