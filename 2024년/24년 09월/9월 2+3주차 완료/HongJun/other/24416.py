# cnt1 = 0
cnt2 = 0
# def recur_fib(n):
#     global cnt1
#     if n == 1 or n == 2:
#         return 1
#     else:
#         cnt1 += 1
#         return recur_fib(n-1) + recur_fib(n-2)

def dp_fib(n):
    global cnt2
    dp = [0] * (n+1)
    dp[1] = 1
    dp[2] = 1

    for i in range(3, n+1):
        cnt2 += 1
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]


N = int(input())
res = dp_fib(N)

print(res, cnt2)