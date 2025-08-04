# [백준 - S5] 1417. 국회의원 선거

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 우선순위 큐, 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 1번 이외의 다른 득표수 중 가장 큰 값에서 1을 빼서 1번 득표수에 더해준다.
2. 파이썬의 우선순위 큐인 heapq는 최솟값 우선순위 큐이기 때문에 -1을 곱해서 넣어준다.
3. 1번을 제외한 나머지 숫자 중 최대값이 1번 득표수보다 작을 때를 찾으면 된다.
4. n=1 일 때는 0을 출력해야한다. 1인 경우를 고려하지 않으면 index error가 나온다.
```python
if n == 1:
    print(0)
else:
    while True:
        max_value = heapq.heappop(pq) * -1

        if my > max_value:
            print(result)
            break

        max_value -= 1
        my += 1
        result += 1
        heapq.heappush(pq, max_value * -1)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1417
