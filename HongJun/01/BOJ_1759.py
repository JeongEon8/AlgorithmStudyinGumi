from itertools import combinations

l, c = map(int, input().split())
alp = list(map(str, input().split()))

alp.sort()

vowels = ['a', 'e', 'i', 'o', 'u']
combis = list(combinations(alp, l))
for pw in combis:
    ja = 0
    mo = 0
    for i in pw:
        if i in vowels:
            mo += 1
        else:
            ja += 1

    if mo >= 1 and ja >= 2:
        tmp = ''.join(pw)
        print(tmp)
