# [백준] 11659. 구간 합 구하기 4
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
구간 합 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 값 입력
            sum[i + 1] = sum[i] + arr[i]; // 부분 합 계산
        }
```

```java
            // 부분 합 계산: sum[b] - sum[a-1]
            int result = sum[b] - sum[a - 1];
```


## :black_nib: **Review**
- 어렵게 생각했는데 그럴 필요가 없는 문제였다.

## 📡**Link**
- https://www.acmicpc.net/problem/11659
