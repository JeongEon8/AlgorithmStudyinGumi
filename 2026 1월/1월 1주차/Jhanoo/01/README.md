# [백준 - 골드 5] 2166. 다각형의 면적

## ⏰**time**

30분

## :pushpin: **Algorithm**

신발끈 공식

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 신발끈 공식을 사용하여 다각형의 면적을 구한다.

   \[
   \text{Area}
   = \frac{1}{2}
   \left|
   \begin{vmatrix}
   x_1 & x_2 & x_3 & \cdots & x_n & x_1 \\
   y_1 & y_2 & y_3 & \cdots & y_n & y_1
   \end{vmatrix}
   \right|
   \]

## :black_nib: **Review**

- 출력 포맷을 소숫점 첫째 자리까지 출력인데, `printf("%.1f")` 로 하지 않아서 틀렸었다.

## 📡 Link

https://www.acmicpc.net/problem/2166
