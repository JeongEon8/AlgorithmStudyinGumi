# [백준- S5] 4659. 비밀번호 발음하기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 구현, 문자열

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 모음 a e i o u가 무조건 하나느 ㄴ있어야하고, 모음 자음이 연속 3개는 안된다는 조건이 있다.
- 머저 모음의 수를 세서 개수가 0인 경우 분기처리를 한다.
- 그리고 모음, 자음이 연속으로 3개 오는지 인덱스로 i, i+1, i+2를 확인해서 분기처리를 한다.
- ee, oo 연속은 허용하는 것으로 다음 분기 처리를 한다.
  
```python
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
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/4659
