# [백준 - S5] 1193. 분수찾기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
- 지그재그로 순서가 정해지기 때문에 홀수줄과 짝수줄을 나눠서 생각한다.
- x를 1, 3, 6, 10... 보다 작아지는 순간을 while문으로 찾는다.
- 대각선에서 몇 번째에 존재하는지 구한다.
```python
    if cnt % 2 == 0:  # 짝수번째
        numer = cnt - temp
        denomin = temp + 1
    else:  # 홀수번째
        numer = temp + 1
        denomin = cnt - temp
```

## :black_nib: **Review**


## 📡 Link
https://www.acmicpc.net/problem/1193
