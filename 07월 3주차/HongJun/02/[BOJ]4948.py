num = []


def sosu(n):
    count = 0
    if n == 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            count += 1
            break
    if count == 0:
        num.append(n)
        return


for i in range(2, 123456 * 2 + 1):
    sosu(i)

while 1:
    n = int(input())
    result = 0
    if n == 0:
        break
    for i in num:
        if n < i <= 2 * n:
            result += 1
    print(result)
