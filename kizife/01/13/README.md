# [백준] 1330. 두 수 비교하기
 
## ⏰  **time**
3분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 두 수를 입력받아 변수 A, B에 저장한다.

2. A>B, A==B, 이외의 경우(즉 A<B)로 나누어 if(else)문을 걸어준다.
if( A > B) {
            System.out.println(">");
        } else if (A==B) {
            System.out.println("==");
        } else {
            System.out.println("<");
        };


## :black_nib: **Review**
- 마지막 else문에는 조건을 명시하지 않아도 되는데(A<B) 무의식적으로 걸어서 컴파일 에러 났었다. 
