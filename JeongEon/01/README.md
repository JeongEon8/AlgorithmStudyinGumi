# [백준 - 실버 5] 1476. 날짜계산

## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 모든 날짜가 같을 때까지 숫자를 1씩 더한다..
```cpp
    while(1){
        if(re == 16){
            re = 1;
        }
        if(rs == 29){
            rs = 1;
        }
        if(rm == 20){
            rm = 1;
        }
        if(re == e & rs == s & rm == m){
            cout << count;
            break;

        }
        re++;
        rs++;
        rm++;
        count++;
    }
```

## :black_nib: **Review**
- 간단하구만! 이게 돌아갈 수 있는 건 분명 실버 5라서 가능한거겠지..? ㅎㅎ

## 📡 Link
https://www.acmicpc.net/problem/1476
