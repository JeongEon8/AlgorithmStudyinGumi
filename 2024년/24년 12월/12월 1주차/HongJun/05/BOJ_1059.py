L = int(input())
S = list(map(int, input().split()))
n = int(input())

S.sort()
ans = 0

fir = 0
sec = 0
if n not in S:
    for i in range(L):
        if n > S[i]:
            fir = S[i]
            continue
        else:
            sec = S[i]
            break
    fir += 1
    sec -= 1

    ans = (n-fir)*(sec-n+1) + (sec-n)

print(ans)