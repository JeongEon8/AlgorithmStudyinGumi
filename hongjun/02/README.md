# [백준 - S5] 2161. 카드1

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 자료구조, 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 1부터 N까지 큐에 넣는다.
- 맨 앞의 숫자를 pop
- 맨 앞의 숫자를 pop하고 맨 끝에 삽입
- 이 과정을 반복한다
- pop한 숫자를 차례대로 출력한다
```python
count=0
while dq:
    if count%2 == 0:
        res.append(dq.popleft())
    else:
        tmp = dq.popleft()
        dq.append(tmp)
    count += 1
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2161
