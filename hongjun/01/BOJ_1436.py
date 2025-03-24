n = int(input())
first = 666
while 1:
    if '666' in str(first):
        n -= 1
        if n == 0:
            break
    first += 1
print(first)