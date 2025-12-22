x = int(input())
i = 0
count = 1
while x > i:
    i = i + count
    count += 1

cnt = count - 1
temp = i - x
numer = denomin = 0

if x == 1:
    print(1, '/', 1, sep='')
else:
    if cnt % 2 == 0:  # 짝수번째
        numer = cnt - temp
        denomin = temp + 1
    else:  # 홀수번째
        numer = temp + 1
        denomin = cnt - temp
    print(numer, '/', denomin, sep='')