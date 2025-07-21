# [백준 - S4] 1026. 보물

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
배열 B에서 정렬을 하고 작은 수에는 A 배열의 큰 수를 매핑하고, 큰 수에는 A 배열의 작은 수를 매핑하면
각 위치에 있는 수를 곱했을 때 최솟값이 나온다.
그래서 A 배열을 오름차순으로 정렬을 하고, B 배열을 내림차순으로 정렬한 뒤,
같은 위치에 있는 수들을 곱해서 더하면 된다.
```python
n=int(input())
s1 = list(map(int, input().split()))
s2 = list(map(int, input().split()))
s1.sort()
s2.sort(reverse=True)
sum=0
for i in range(n):
    sum += s1[i]*s2[i]   
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1026
