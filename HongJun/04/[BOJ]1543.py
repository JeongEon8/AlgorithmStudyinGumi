txt = input()
find = input()
n = len(find)
cnt = 0
i = 0
while i<len(txt):
    if txt[i:i+n] == find:
        i += n
        cnt += 1
    else:
        i += 1
print(cnt)