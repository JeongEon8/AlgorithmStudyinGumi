# 정점 100까지 / 간선 = 5000까지 -> 플로이드 워셜
n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    graph[i][i] = 0

for i in range(m):
    a, b = map(int, input().split())
    # 서로 친구관계이기 때문에 양방향임
    graph[a][b] = 1
    graph[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            # 바로 가는거랑 다른 정점을 거쳐서 가는거랑 비교해서 더 작은 값으로 변경
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

# 각 배열의 합을 더한 값을 따로 저장
res = [0] * (n+1)
for i in range(1, n+1):
    res[i] = sum(graph[i][1:])
min_value = min(res[1:])

# 결과값으로 합이 최소값인 것의 인덱스를 출력
# 최소값을 가지는 것이 중복이면 그 중 작은 인덱스를 출력
for idx in range(1, n+1):
    if res[idx] == min_value:
        print(idx)
        break