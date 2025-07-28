mo = ['a', 'e', 'i', 'o', 'u']
mul = ['ee', 'oo']
while 1:
    pw = input()
    if pw == 'end':
        break

    cnt = 0
    for i in pw:
        if i in mo:
            cnt += 1
    if cnt == 0:
        print(f'<{pw}> is not acceptable.')
        continue

    flag_3 = False
    for i in range(len(pw) - 2):
        if pw[i] in mo and pw[i + 1] in mo and pw[i + 2] in mo:
            flag_3 = True
        elif pw[i] not in mo and pw[i + 1] not in mo and pw[i + 2] not in mo:
            flag_3 = True
    if flag_3:
        print(f'<{pw}> is not acceptable.')
        continue

    flag_2 = False
    for i in range(len(pw) - 1):
        if pw[i] == pw[i + 1]:
            if pw[i] == 'e' or pw[i] == 'o':
                continue
            else:
                flag_2 = True
    if flag_2:
        print(f'<{pw}> is not acceptable.')
        continue

    print(f'<{pw}> is acceptable.')