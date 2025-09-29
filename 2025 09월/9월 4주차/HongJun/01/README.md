# [백준- S3] 13305. 주유소
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 새로운 최저가를 찾았을 때 (지금까지 누적된 거리) * (현재 최저가) 이 값을 출력값에 추가한다
- 앞으로 가야하는 거리를 갱신하고, 최저가도 갱신한다.
- 다음 주유소가 최저가가 아니면 거리만 더해준다.
- n-2가 마지막 주유소이기 때문에 결과값에 (거리*최저가)를 더하고 출력한다
  
```python
for i in range(1, n-1):
    if cost > liter[i]: 
        res += dist*cost 
        dist = km[i]        
        cost = liter[i]   
    else:
        dist += km[i] 

    if i == n-2:
        res += dist*cost
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/13305