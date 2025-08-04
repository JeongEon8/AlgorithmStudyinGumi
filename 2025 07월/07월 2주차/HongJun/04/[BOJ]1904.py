N = int(input())
dp = [0] * (N+1)
dp[1] = 1
dp[2] = 2
for i in range(3, N+1):
    dp[i] = (dp[i-2] + dp[i-1])%15746

print(dp[-1])