N, M = map(int, input().split())
res = []
visited = [False] * (N+1)

# num = 깊이, degree, count
# 중복없이 M개
def recur(num):
    if num == M:
        # 결과 출력
        print(' '.join(map(str, res)))
        return
    # 1부터 N까지 자연수
    for i in range(1, N+1):
        if visited[i] == False:
            visited[i] = True
            # 결과값 배열에 탐색한 숫자를 추가
            res.append(i)
            recur(num+1)
            # 재귀 끝나면 결과값 배열에서 빼주고 방문여부도 False로 바꿔야함
            visited[i] = False
            res.pop()

# 0부터 시작
recur(0)