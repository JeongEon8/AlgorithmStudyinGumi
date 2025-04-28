# [백준 - S4] 1822. 차집합

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료구조, 행렬
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 처음에는 그냥 리스트를 전부 탐색해서 B에 존재하는건 빼고 새로운 배열에 a 원소를 추가했다.
- 근데 그럼 50만*50만 이라서 시간초과가 난다
- 그래서 set을 사용해서 집합으로 만들고 a-b를 하면 자동으로 차집합이 구해진다.
- 출력할 때 정렬해줘야한다.
```python
a = set(map(int, input().split()))
b = set(map(int, input().split()))
res = a-b
print(*sorted(res))
```

## :black_nib: **Review**  

## 📡**Link**

https://www.acmicpc.net/problem/1822
