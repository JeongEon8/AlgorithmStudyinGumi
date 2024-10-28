N = int(input())
M = int(input())

nobtn = []  # 고장난 버튼
if M != 0:
    nobtn = list(map(int, input().split()))

numbtn = [] # 고장 안나서 누를 수 있는 버튼
for i in range(10):
    if i not in nobtn:
        numbtn.append(i)

MIN_VALUE = abs(N-100) # 100에서 출발해서 목표 채널까지 +, -만 눌러서 가는 경우
def dfs(path, cnt):
    global MIN_VALUE
    if cnt == len(str(N))-1 and len(str(N)) != 0:
        if path:
            ch = int("".join(map(str, path)))
            MIN_VALUE = min(MIN_VALUE, len(path) + abs(N - ch))

    if cnt == len(str(N)):
        if path:
            ch = int("".join(map(str, path)))
            MIN_VALUE = min(MIN_VALUE, len(path) + abs(N - ch))

    if cnt == len(str(N))+1:
        if path:
            ch = int("".join(map(str, path)))
            MIN_VALUE = min(MIN_VALUE, len(path) + abs(N - ch))
        return

    for i in numbtn:
        path.append(i)
        dfs(path, cnt + 1)
        path.pop()


dfs([], 0)


print(MIN_VALUE)