# [백준- S4] 1158. 요세푸스 문제
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 구현, 큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 리스트의 길이가 k-1보다 더 크면 리스트에서 k번째에 있는 수를 빼서 result에 넣는다
- 그리고 기존 k번째를 더한다.
- 반대로 더 작은 경우에는 리스트 길이만큼 나누고 그 나머지를 사이클로 지정한다.
  
```python
for i in range(n):
    if len(li) > cycle:
        temp = li.pop(cycle)
        result.append(temp)
        cycle = cycle + k - 1
    else:
        cycle = cycle % len(li)
        temp = li.pop(cycle)
        result.append(temp)
        cycle = cycle + k - 1
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1158
