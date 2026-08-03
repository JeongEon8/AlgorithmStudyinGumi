# [PGS - Lv2] 02_최솟값 만들기

## ⏰**time**

- 23분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. A, B를 sort를 이용해서 정렬을 시켜준다
2. A는 시작부터 B는 끝에서부터 꺼내서 곱해서 결과값에 더해준다.
   ```
   Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i< A.length; i++){
           answer+= A[i]*B[B.length-1-i];
        }
   ```

## :black_nib: **Review**

- 처음에는 sort에서 역순으로 하고 싶었는데 int[] 타입이라서 안되고 Integer로 변환해야 가능하다고 해서 포기함 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12941
