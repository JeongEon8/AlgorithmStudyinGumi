# [PGS - LV2] 132265. 롤케이크 자르기

## ⏰ **time**

15분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
일단 다 오른쪽배열에 들어있다고 치고 한조각씩 왼쪽으로 옮기는 방식으로 진행한다.  
왼쪽에 새로 들어오면 왼쪽 종류수를 올려주고 오른쪽에서 0조각이되면 오른쪽 종류수를 내려준다.
종류수가 같을 때를 확인하고 왼쪽이 더 종류가 많아지면 더 탐색할 필요 없이 종료한다.
```java
for(int t:topping){
    if(right[t]==0){
        rightCnt++;
    }
    right[t]++;
}
for(int t:topping){
    if(!left[t]){
        left[t] = true;
        leftCnt++;
    }
    right[t]--;
    if(right[t]==0){
        rightCnt--;
    }
    if(rightCnt==leftCnt){
        answer++;
    }
    if(leftCnt>rightCnt)break;
}
```
## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/132265