import sys
input = sys.stdin.readline

n, c = map(int, input().split())
arr = []
for i in range(n):
    arr.append(int(input()))
arr.sort()

start = 1               # 최소 거리
end = arr[-1] - arr[0]  # 최대 거리 (끝 값 - 시작 값)

result = 0
while start <= end:
    mid = (start + end) // 2
    now = arr[0]  # 공유기 초기 위치 설정
    count = 1

    # 처음부터 공유기 설치
    for i in range(1, len(arr)):
        # 첫 집과 공유기 사이의 거리 = mid값 이상일 때
        if arr[i] - now >= mid:
            now = arr[i]
            count += 1

    # 설치한 공유기 수가 c 이상일 때
    if count >= c:
        start = mid + 1     # start값 갱신
        result = mid        # 중간 값을 답으로 갱신
    else:
        end = mid - 1

print(result)