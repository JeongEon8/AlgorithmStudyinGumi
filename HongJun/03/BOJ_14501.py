n = int(input())
T = [0] * n
P = [0] * n

for i in range(n):
    T[i], P[i] = map(int, input().split())

dp = [0] * (n+1)

# 뒤에서 앞으로
for i in range(n-1, -1, -1):
    # 남은 날 안에 있을 때만 가능
    if i + T[i] <= n:
        # i번째 날에 상담 안할 때, 할 때 비교
        dp[i] = max(dp[i+1], dp[i + T[i]] + P[i])
    else:
        dp[i] = dp[i+1]

print(dp[0])