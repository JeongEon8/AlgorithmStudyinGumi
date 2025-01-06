n=int(input())
tree = list(map(int, input().split()))
answer = 'YES'

two_cnt = 0
if sum(tree)%3 != 0:
    answer = 'NO'
else:
    for tr in tree:
        two_cnt += tr//2
    if two_cnt < sum(tree)//3:
        answer = 'NO'

print(answer)