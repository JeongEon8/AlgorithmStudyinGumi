n, r, c = map(int, input().split())
cnt = 0

# size = 탐색할 배열의 크기
def Z(x, y, size):
    global cnt
    # 좌표가 일치하면 종료
    if x == c and y == r:
        print(int(cnt))
        return
    # 사분면 안에 있으면 재귀
    elif x <= c < x+size and y <= r < y+size:
        # 1 번째
        Z(x, y, size/2)
        # 2 번째
        Z(x + size/2, y, size/2)
        # 3 번째
        Z(x, y + size/2, size/2)
        # 4 번째
        Z(x + size/2, y + size/2, size/2)
    # 사분면 안에 없으면 다음 사분면으로 넘어감
    # 탐색한 사분면의 숫자 카운트를 더해준다
    else:
        cnt += size*size

# (0, 0) 부터 시작해서 탐색
Z(0, 0, 2**n)