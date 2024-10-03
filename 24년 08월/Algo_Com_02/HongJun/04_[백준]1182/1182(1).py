N, S = map(int, input().split())
nums = list(map(int, input().split()))
cnt = 0
res = []

def recur(idx):
    global cnt
    
    # 부분 수열의 합이 S가 되면 경우의 수 +1
    # 비어있는 리스트의 sum을 구하면 0이 나오니까 리스트의 길이를 확인하는 조건도 넣어야함
    if sum(res) == S and len(res) > 0:
        cnt += 1

    # 파라미터로 받은 시작 인덱스부터 탐색
    for i in range(idx, N):
        res.append(nums[i])
        recur(i+1)
        res.pop()

recur(0)
print(cnt)