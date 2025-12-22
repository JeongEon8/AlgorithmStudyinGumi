# [백준 - S5] 1439. 뒤집기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 그리디, 문자열

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 0과 1의 갯수를 구한다
- N, N+1 위치의 숫자가 다를 때 0, 1인지 확인하고 카운트를 센다
- 0과 1 중 모여있는 수가 더 작은 것을 출력한다.
  
```python
for i in range(1, len(s)):
    if s[i-1] != s[i]:
        if s[i] == '1':
            one += 1
        else:
            zero += 1
```

## :black_nib: **Review**열
## 📡**Link**
- https://www.acmicpc.net/problem/1439
