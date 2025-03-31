# [프로그래머스 - LV.2] 전화번호 목록
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 전화번호 길이 만큼 잘라봐서 해시에 저장되어 있느지 확인
```java
    for(String address : phone_book){
            String tmp = "";
            for(int i=0;i<address.length();i++){
                tmp = address.substring(0,i);
                if(map.get(tmp)!=null)answer=false;
            }
            if(answer==false)break;
        }
```

## :black_nib: **Review**
-

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java
