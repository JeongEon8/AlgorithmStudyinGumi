N, S = map(int, input().split())
nums = list(map(int, input().split()))
cnt = 0

# 인덱스 번호와 지금까지 탐색한 수열의 합을 인자로 받는다
def dfs(idx, sum):
    global cnt

    # 인덱스가 N을 넘어가면 return
    if (idx >= N):
        return
    
    # 합에 현재 탐색 숫자를 더해줌
    sum += nums[idx]

    # 더한 값이 S와 같으면 카운츠 +1
    if sum == S:
        cnt += 1

    # 현재 탐색하는 숫자를 선택한 경우
    dfs(idx+1, sum)
    # 현재 탐색하는 숫자를 선택하지 않은 경우
    dfs(idx+1, sum-nums[idx])


dfs(0,0)
print(cnt)