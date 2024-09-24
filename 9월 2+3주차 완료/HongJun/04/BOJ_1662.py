S = list(input())
n = len(S)

K_li = []
len_li = []

count = 0
k = ''
for i in range(n):

    if S[i] == '(':
        K_li.append(k)
        len_li.append(count-1)
        count = 0

    elif S[i] == ')':
        count = len_li.pop() + K_li.pop()*count

    else:
        count += 1
        k = int(S[i])
print(count)