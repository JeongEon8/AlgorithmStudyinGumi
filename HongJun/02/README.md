# [백준 - S5] 11931. 수 정렬하기 4

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
파이썬의 일반 정렬을 사용하면 N^2으로 시간초과가 날 것 같아서 힙큐를 사용했다.
sys 라이브러리를 사용해서 input을 최적화 해줘야 시간초과가 안난다

```python
input = sys.stdin.readline

n = int(input())
nums = []
for _ in range(n):
    heapq.heappush(nums, int(input())*-1)

for i in range(n):
    print(heapq.heappop(nums)*-1)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/11931
