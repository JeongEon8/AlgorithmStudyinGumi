month, day, year, time = input().split()
h = time[:2]
m = time[3:]
day = day[:2]

days = {"January" : 1, "February" : 2,
 "March" : 3, "April" : 4,
 "May" : 5, "June" : 6,
 "July" : 7, "August" : 8, "September" : 9,
 "October" : 10, "November" : 11, "December" : 12}

month_days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

isyoon = False
year = int(year)
day = int(day)
if (year%4 == 0 and year%100 != 0) or year%400 == 0:
    isyoon = True

total_days = 365
if isyoon:
    total_days += 1
    month_days[1] += 1

total_minute = total_days*24*60

cur_month = days[month]
cur_total_day = day-1
for i in range(cur_month-1):
    cur_total_day += month_days[i]

cur_total_min = cur_total_day*24*60 + int(h)*60 + int(m)

ans = (cur_total_min*100)/total_minute
print(ans)