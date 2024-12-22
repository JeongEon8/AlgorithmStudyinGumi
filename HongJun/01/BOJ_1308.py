one = [1,3,5,7,8,10,12]
zero = [4,6,9,11]

y1, m1, d1 = map(int, input().split())
y2, m2, d2 = map(int, input().split())

def yoon_check(year):
    if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
        return True
    else:
        return False

def total_day_count(y, m, d):
    total1 = 0
    for i in range(1, y):
        if yoon_check(i):
            total1 += 366
        else:
            total1 += 365

    for i in range(1, m):
        if i == 2:
            if yoon_check(y):
                total1 += 29
            else:
                total1 += 28
        else:
            if i in one:
                total1 += 31
            else:
                total1 += 30
    total1 += d
    return total1

limit = total_day_count(1001, 1, 1)

total1 = total_day_count(y1, m1, d1)
total2 = total_day_count(y2, m2, d2)
answer = total2 - total1

if answer < limit:
    print(f'D-{answer}')
else:
    print('gg')