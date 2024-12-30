s1, s2 = list(input()), list(input())
l1, l2 = len(s1), len(s2)

dp = [[0] * (l2 + 1) for _ in range(l1 + 1)]

for i in range(1, l1 + 1):
    for j in range(1, l2 + 1):
        # 같은 알파벳일 때 +1
        if s1[i - 1] == s2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1

        # 다른 경우, 이전의 값에서 최댓값
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

# 맨 끝에 있는 값 출력
print(dp[-1][-1])