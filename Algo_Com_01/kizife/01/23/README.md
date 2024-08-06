# [백준] 2438. 별 찍기 - 1
 
## ⏰  **time**
5분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
- 입력한 숫자 A만큼 반복하는 구문
- 안에서 i만큼 * 반복출력
- 이때, 줄바꿈이 없도록 print를 사용한다.
  for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
  

## :black_nib: **Review**
- 처음에 result = "*"*i;라는 터무니없는 표현을 넣었다...
