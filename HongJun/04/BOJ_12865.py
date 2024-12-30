import sys

input = sys.stdin.readline

n, k = map(int, input().split())
pack = [[0, 0]]
dp = [[0] * (k + 1) for _ in range(n + 1)]

for _ in range(n):
    pack.append(list(map(int, input().split())))

for i in range(1, n + 1):
    for j in range(1, k + 1):  # J => 가방이 버틸 수 있는 무게 (1부터 k까지)
        w = pack[i][0]  # 무게
        v = pack[i][1]  # 가치

        # 버틸 수 있는 무게인지 확인
        # 버티지 못하면 이전꺼 그대로
        if j < w:
            dp[i][j] = dp[i - 1][j]
        # 버틸 수 있으면 둘 중 큰 값으로 갱신
        else:
            dp[i][j] = max(dp[i - 1][j - w] + v, dp[i - 1][j])

print(dp[n][k])