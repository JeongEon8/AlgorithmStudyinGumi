# [백준 - S5] 8979. 올림픽

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현, 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
파이썬의 람다를 사용해서 우선순위대로 정렬을 한다.
그리고 입력한 k번째 나라의 등수를 구한다.
메달의 수 3개를 비교해서 다 같으면 +1을 해서 출력한다.

```python
medal.sort(key=lambda x: (x[1], x[2], x[3]), reverse=True)

idx = [medal[i][0] for i in range(n)].index(k)

for j in range(n):
    if medal[idx][1:] == medal[j][1:]:
        print(j+1)
        break
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/8979
