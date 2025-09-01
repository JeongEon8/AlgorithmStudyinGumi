s=input()
zero=0
one=0
if s[0] == '0':
    zero += 1
else:
    one += 1

for i in range(1, len(s)):
    if s[i-1] != s[i]:
        if s[i] == '1':
            one += 1
        else:
            zero += 1
if zero == 0 or one == 0:
    print(0)
else:
    print(min(zero, one))