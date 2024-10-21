n, s = map(int, input().split())
li = list(map(int, input().split()))

st = 0      # 시작
en = 0      # 끝

leng = []   # 수열의 길이 저장
tmp_sum = 0  # 수열 합

for st in range(n):
    while tmp_sum < s and en < n:
        tmp_sum += li[en]
        en += 1

    if tmp_sum >= s:
        leng.append(en-st)
    tmp_sum -= li[st]


if leng:
    print(min(leng))
else:
    print(0)