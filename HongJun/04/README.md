# [백준- S4] 1015. 수열 정렬
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
-

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 먼저 수열을 오름차순으로 정렬한 리스트를 만든다.
- 기존 수열과 정렬된 수열을 비교한다.
- 인덱스에 있는 숫자가 같을 경우, 그 인덱스+1 값이 결과값에 없으면 추가한다
- 숫자가 다를 경우, 그 인덱스를 그대로 넣는다
  
```python
for i in range(N):
    for j in range(N):
        if arr[i] == sort_arr[j]:
            if j in res:
                res.append(j+1)
            else:
                res.append(j)
            sort_arr[j] = -1
            break
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1015
