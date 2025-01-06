N = int(input())

max_dp = [0] * 3
min_dp = [0] * 3

tmp1 = [0] * 3
tmp2 = [0] * 3

for i in range(N):
    a, b, c = map(int, input().split())
    # 최대값
    for j in range(3):
        if j == 0:
            tmp1[j] = max(a + max_dp[j], a + max_dp[j+1])

        elif j == 1:
            tmp1[j] = max(b + max_dp[j-1], b + max_dp[j], b + max_dp[j+1])

        elif j == 2:
            tmp1[j] = max(c + max_dp[j - 1], c + max_dp[j])

    # 최소값
    for j in range(3):
        if j == 0:
            tmp2[j] = min(a + min_dp[j], a + min_dp[j + 1])

        elif j == 1:
            tmp2[j] = min(b + min_dp[j - 1], b + min_dp[j], b + min_dp[j + 1])

        elif j == 2:
            tmp2[j] = min(c + min_dp[j - 1], c + min_dp[j])


    # dp 갱신
    for k in range(3):
        max_dp[k] = tmp1[k]
        min_dp[k] = tmp2[k]

print(max(max_dp), min(min_dp))