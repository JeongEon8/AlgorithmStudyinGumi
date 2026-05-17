# [PGS - Lv2] 02_최솟값 만들기

## ⏰**time**

40분

## :pushpin: **Algorithm**

- 정렬
- 그리디

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. (풀이 방식을 작성해주세요.)
   ```
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length - i - 1];
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12941
