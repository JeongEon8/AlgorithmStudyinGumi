# [백준 - S4] 2217. 로프

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
입력한 N개의 수를 리스트에 넣고 내림차순으로 정렬한다.
N개의 로프를 사용해서 들 수 있는 최대 무게를 구해야한다.
각 로프에는 w/k만큼 걸린다고 했으니 1씩 더해서 곱한 값 중 최대값을 출력하면 된다.
```python
li.sort(reverse=True)
res = []
tmp = 0
for i in range(n):
    num = i+1
    res.append(li[i]*num)
print(max(res))
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/2217
