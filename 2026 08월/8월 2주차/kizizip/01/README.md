# [PGS - Lv1] 01_최대공약수와 최소공배수

## ⏰**time**

5분

## :pushpin: **Algorithm**

(알고리즘을 작성해주세요.)

## ⏲️**Time Complexity**

$O(max(n, m))$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. n, m 중에 큰 걸 기준으로 삼고 그거보다 작은 숫자들로 n, m 나눠주면서 나머지가 0이면 최대공약수 갱신. 근데 이 논리는 사실 잘못 쓴 거임;; 틀린 답은 아닌데 작은 걸 기준으로 삼았어야 효율이 올라감 근데 아무 지능 없이 냅다 Math.max 씀 
2. 둘 중에 큰 걸 기준으로 곱 늘려가면서 그걸 작은 값이 딱 떨어지게 나눌 수 있는지 검토.. 값 찾으면 종료하기 위해 tf라는 기준점 둠. 

## :black_nib: **Review**

- 그냥 무식하게 풀었음 머리 굳어서..

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=java
