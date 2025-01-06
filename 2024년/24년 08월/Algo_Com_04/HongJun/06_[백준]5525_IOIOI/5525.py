n = int(input())
m = int(input())
S = input()

idx, count = 0, 0
result = 0
while idx < (m-1):
    # idx부터 길이가 3인곳 까지 IOI인지 확인
    if S[idx:idx+3] == 'IOI':
        count += 1
        idx += 2    # 다음으로 이동 -> +2


        if count == n:
            result += 1
            count -= 1
    else:
        idx += 1
        count = 0
print(result)
# pn_len = n*2 + 1
#
# tmp = []
# for i in range(pn_len):
#     if i%2 == 0:
#         tmp.append('I')
#     else:
#         tmp.append('O')
# pn = ''.join(tmp)
#
# cnt = 0
# for i in range(m-len(tmp)+1):
#     if S[i] == 'I':
#         if S[i:i+pn_len] == pn:
#             cnt += 1
# print(cnt)

