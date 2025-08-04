# [백준 - S3] 1904. 01타일

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- DP

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
N=1 일 때 1만 가능, N=2 일 때 00, 11이 가능하다
그러면 N=3일 때는 100, 001, 111 이렇게 3개 가능하다
이건 N=1인 경우인 것에 00을 붙인 것과 N=2인 것에 1을 붙인 경우와 같다.

DP 점화식 : dp[n] = (dp[n-2]+00) + (dp[n-2]+1)
출력에서 15746으로 나눈 나머지를 출력하라고 했다.

```python
N = int(input())
dp = [0] * (N+1)
dp[1] = 1
dp[2] = 2
for i in range(3, N+1):
    dp[i] = (dp[i-2] + dp[i-1])%15746

print(dp[-1])
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1904
