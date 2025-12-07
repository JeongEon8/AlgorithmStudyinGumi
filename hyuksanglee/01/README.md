# [프로그래머스 - lv2] 테이블 해시 함수

## ⏰  **time**

40분

## ⏲️**Time Complexity**

$O(N)$

## 풀이

1.col에 맞게 정렬 Arrays.sort를 이용해서 정렬

```java
Arrays.sort(data, (a, b) -> {
            if (a[col-1] != b[col-1]) return a[col-1] - b[col-1];
            return b[0] - a[0]; 
        });
```
2. row_begin부터 row_end까지 나머지를 계산해서 oxr 해준다.
```java
for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i-1];
            int sum = 0;
            for (int v : row) {
                sum += (v % i);
            }
            answer ^= sum;
        }
```

## :black_nib: **Review**

## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/147354
