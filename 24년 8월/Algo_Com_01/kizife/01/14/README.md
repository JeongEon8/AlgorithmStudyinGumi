# [백준] 9498. 시험 성적
 
## ⏰  **time**
2분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 점수를 입력받는다. 범위가 작은 정수이므로 편하게 int 처리함.

2. 점수 구간에 따라 if문 걸어 출력값을 지정한다.
        if (A >= 90){
            System.out.println("A");
        } else if (A>=80) {
            System.out.println("B");
        } else if (A>=70){
            System.out.println("C");
        } else if (A>=60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        };
   

## :black_nib: **Review**
- 어려울 것 없었다...!
