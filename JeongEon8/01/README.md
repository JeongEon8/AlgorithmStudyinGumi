# [PGS - Lv1] 01_부족한 금액 계산하기

## ⏰**time**
10분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 배수씩 계속 더해서, money가 더 크면 0을 출력하고, 아니면 두 값을 뺸 절대값을 반환한다.
   ```cpp
    for(int i = 1; i <= count; i++){
        sum += price * i;
    }
    
    if(money > sum){
        answer = 0;
    }
    else{
        answer = abs(money - sum);        
    }
   ```

## :black_nib: **Review**
- 문제를 꼼꼼하게 읽자.

## 📡 Link
[프로그래머스 Lv1 부족한 금액 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/82612)
