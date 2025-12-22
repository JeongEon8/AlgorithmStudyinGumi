# [백준 - S4] 28278. 스택2

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
입력한 숫자 1, 2, 3, 4, 5의 조건대로 분기처리를 한다.
리스트에서 pop을 해서 출력하거나 비어있는 리스트인지 확인하면 된다.
```python
    if tmp[0] == 1:
        dq.append(tmp[1])
    elif tmp[0] == 2:
        if dq:
            pop_num = dq.pop()
            print(pop_num)
        else:
            print(-1)
    elif tmp[0] == 3:
        print(len(dq))
    elif tmp[0] == 4:
        if dq:
            print(0)
        else:
            print(1)
    elif tmp[0] == 5:
        if dq:
            print(dq[-1])
        else:
            print(-1)
```

## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/28278
