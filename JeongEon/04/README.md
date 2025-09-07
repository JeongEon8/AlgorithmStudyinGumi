# \[백준 - 실버 1] 11660. 구간 합 구하기 5

## ⏰  **time**

10분

## \:pushpin: **Algorithm**

2차원 누적합 (Prefix Sum)

## ⏲️**Time Complexity**
\$O(N^2 + M)\$

## \:round\_pushpin: **Logic**

1. 입력받은 2차원 배열에서, `(i, j)`까지의 **누적합**을 `map[i][j]`에 저장.

   * 점화식:

     ```
     map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + arr[i][j]
     ```
2. 질의는 `(x1, y1)`에서 `(x2, y2)`까지의 부분 합을 구하는 것:

   * 부분합 공식:

     ```
     sum = map[x2][y2] 
           - map[x1-1][y2] 
           - map[x2][y1-1] 
           + map[x1-1][y1-1]
     ```
3. 이 방식을 쓰면 **모든 질의**에 대해 시간복잡도 $O(1)$로 응답 가능.

```cpp
map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + temp;
```

```cpp
int sum = map[x2][y2] 
        - map[x1-1][y2] 
        - map[x2][y1-1] 
        + map[x1-1][y1-1];
```

## \:black\_nib: **Review**

* 누적합 공식만 정확히 세우면 이후 질의 처리 속도가 매우 빠르다.
* 1-based index를 쓰면 범위 체크, 인덱스 예외 없이 깔끔하게 처리 가능.
* 2차원 누적합 문제의 전형적인 풀이법!

## 📡 Link

[https://www.acmicpc.net/problem/11660](https://www.acmicpc.net/problem/11660)
