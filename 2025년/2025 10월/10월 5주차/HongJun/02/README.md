# [백준- S5] 9237. 이장님 초대
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 그리디, 정렬

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 나무 심는 순서를 '모든 나무가 가장 빨리 자라도록' 정해야함
- 나무가 다 자라는데 걸리는 날짜 출력
- 심는 날 1일(index + 1) + 자라는 날 + 다음 날 (1일)
- 이 수식으로 자라는 날을 구하고 최댓값을 출력하면 된다.
```python
sort_tree = sorted(tree, reverse=True)

result = []
for i in range(n):
  day = (i+1) + sort_tree[i] + 1
  result.append(day)
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/9237
