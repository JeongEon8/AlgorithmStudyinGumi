# [PGS - LV2] 148653. 마법의 엘리베이터

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(logn)$

## :round_pushpin: **Logic**
1의 자리부터 각 자릿수를 0으로 만드는 식으로 한다.  
5보다 크면 올려주고 5미만은 내려준다.  
만약 5인경우 다음 자릿 수과 5이상이면 올리는게 유리하고 아니면 내리는게 유리하다.
```java
while(storey>0){
    int mod = storey%10;
    storey/=10;
    if(mod>5){
        answer+=10-mod;
        storey++;
    }else if(mod<5){
        answer += mod;
    }else{
        answer+=5;
        if(storey%10>=5){
            storey++;   
        }
    } 
}
```
## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/148653