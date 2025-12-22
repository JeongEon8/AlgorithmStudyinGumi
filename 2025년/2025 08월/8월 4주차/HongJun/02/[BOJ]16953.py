a, b = map(int, input().split())

count = 1
while b != a:
    count += 1
    tmp = b

    if b%10 == 1:
        b = b // 10
    elif b%2 == 0:
        b = b // 2

    if b == tmp:
        print(-1)
        break

else:
    print(count)