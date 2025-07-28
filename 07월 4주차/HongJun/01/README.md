# [백준- S3] 1051. 숫자 정사각형
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 브루트포스

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
- 직사각형에서 정사각형을 찾으려면 두 변 중 작은 길이에 맞춰야한다.
- 그래서 최대 길이를 작은 사이즈로 정하고, 최대 크기를 찾아야하니까 큰 수에서 내려온다.
- 4개의 좌표에 위치한 수가 같으면 size**2를 출력하고 exit으로 종료한다.
  
```python
for size in range(max_cnt, 0, -1):
    for y in range(n-size+1):
        for x in range(m-size+1):
            if li[y][x] == li[y+size-1][x] == li[y][x+size-1] == li[y+size-1][x+size-1]:
                print(size**2)
                exit()
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1051
