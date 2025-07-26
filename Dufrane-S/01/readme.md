# [백준- S3] 1515. 수 이어 쓰기
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현, 브루트 포스

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 1부터 남은 문자열이 없어 질 때까지 계속 지워주기
  
```java
    while(s.length()!=idx){
            String now = i+"";
            for(int j = 0;j<now.length();j++){
                if(now.charAt(j)==s.charAt(idx)){
                    idx++;
                }
                if(idx==s.length()){
                    System.out.println(i);
                
                    return;
                }
            }
            i++;    
        }
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1515
