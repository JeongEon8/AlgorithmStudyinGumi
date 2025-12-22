# [프로그래머스 - Lv2] 행렬의 곱셈

## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 배열

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 두 행과 열의 크기를 int 변수로 선언
- 결과값 answer 2차원 배열을 [arr1 행] * [arr2 열] 크기로 초기화
- 2중 for문으로 arr1의 행, arr2의 열을 탐색
- arr1의 열의 인덱스를 for문으로 탐색해서 두 행렬의 곱을 결과값에 저장

```
for (int i = 0; i < len1; i++) {
    for (int j = 0; j < c2; j++) {
        for (int k = 0; k < c1; k++) {
            answer[i][j] += arr1[i][k] * arr2[k][j];
        }
    }
}
```

## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/12949
