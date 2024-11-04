st = input()

cnt1 = 0
cnt2 = 0

# .으로 split
ex = st.split('.')
flag = True

res = []

for i in range(len(ex)):
    # X가 나올 때
    if ex[i] != '' and ex[i][0] != '.':
        # 개수가 2로 나눠떨어짐
        if len(ex[i])%2 == 0:
            tmp = (len(ex[i]) // 4) * 'AAAA' + (len(ex[i]) % 4) * 'B'
            ex[i] = tmp
        # 홀수인 경우에는 안됨
        else:
            flag = False
            break

for i in range(1, len(ex)):
    ex[i] = '.' + ex[i]

if flag:
    answer = ''.join(ex)
    print(answer)
else:
    print(-1)