# n=int(input())
# li = []
# for i in range(1, n+1):
#     li.append(i)
#
# res = ''.join(map(str, li))
# print(len(res))
#
# n=int(input())
# res = 0
# for i in range(1, n+1):
#     res += len(str(i))
# print(res)

n=input()
length = len(n)

result = 0
for i in range(length-1):
    result += 9*(10**i) * (i+1)
tmp = int(n) - (10**(length-1))
result += (tmp+1)*length

print(result)
# 1~9 => 9 * 1
# 10~99 => 90 * 2
# 100~999 => 900 * 3
# 1000~9999 => 9000 * 4