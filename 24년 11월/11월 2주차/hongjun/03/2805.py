n, m = map(int, input().split())
tree = list(map(int, input().split()))

lo = 0
hi = int(1e9)

def check(mid):
    # 자른 나무들의 합
    sum = 0
    for i in range(n):
        # 나무의 높이가 더 크면 자른다
        if tree[i] > mid:
            sum += tree[i] - mid
    # 자른 나무의 합이 목표 길이 m보다 클 때 리턴
    if sum >= m:
        return 1


while lo + 1 < hi:
    mid = (lo + hi) // 2
    # 이분 탐색으로 가능한 경우를 찾았으면 low를 mid로 설정해서 다시
    if check(mid):
        lo = mid
    # 못찾았으면 high를 mid로 설정
    else:
        hi = mid

print(lo)