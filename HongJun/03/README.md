# [백준 - S5] 2018. 수들의 합 5

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 두포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
start, end 인덱스를 0부터 시작해서
1. 합이 N보다 작으면 end + 1
2. N보다 크면 start + 1
3. 합이 N과 같으면 count+1, start+1
이렇게 조건을 걸면 된다.
그런데 리스트에 1부터 N까지 넣고 인덱스 범위의 합으로 구현하면 메모리초과가 나온다.

```python
for start in range(n):
    while end < n and sum < n:
        sum += end+1
        end += 1
    if sum == n:
        count += 1
    sum -= start+1
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/2018
