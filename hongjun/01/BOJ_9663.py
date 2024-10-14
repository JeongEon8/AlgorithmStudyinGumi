N = int(input())

def dfs(n):
    global answer
    if n == N:
        answer += 1
        return

    for i in range(N):
        # 대각선 검사에서 올바른 인덱스 사용 (v2는 n + i, v3는 n - i + (N-1))
        if v1[i] == 0 and v2[n + i] == 0 and v3[n - i + (N-1)] == 0:
            v1[i] = 1
            v2[n + i] = 1
            v3[n - i + (N-1)] = 1

            dfs(n + 1)

            # 백트래킹 (원상 복귀)
            v1[i] = 0
            v2[n + i] = 0
            v3[n - i + (N-1)] = 0


answer = 0
v1 = [0] * N      # 같은 행을 체크
v2 = [0] * (2 * N)  # 오른쪽 아래 대각선 체크
v3 = [0] * (2 * N)  # 오른쪽 위 대각선 체크

dfs(0)
print(answer)