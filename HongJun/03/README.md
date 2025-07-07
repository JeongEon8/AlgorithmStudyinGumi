# [백준 - S3] 1002. 터렛

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학, 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
두 개의 x, y 좌표를 가지고 거리를 구한다.
만약 거리가 0인 경우에는 r1과 r2가 같으면 -1, 다르면 0을 출력한다.
거리가 0이 아닐 때는 2, 1, 0이 나올 수 있다.
```python
for _ in range(t):
    x1,y1,r1,x2,y2,r2 = map(int, input().split())
    dist = ((x1-x2)**2+(y1-y2)**2)**0.5

    if dist == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        if r1+r2 == dist or abs(r2-r1) == dist:
            print(1)
        elif abs(r2-r1) < dist and dist<r1+r2:
            print(2)
        else:
            print(0)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1002
