# [PGS - LV2] 12924. 숫자의 표현

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 그래프

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
합보다 작으면 뒤로 숫자들을 추가하고 만약 더 크다면 더해놨던 가장 작은수를 빼준다. 같은 경우 카운팅한다.
```java
 int l = 1;
for(int i = 1; i<=n; i++){
    current+=i;
    while(current>n){
        current-=l;
        l++;
    }
    if(current==n) answer++;
}
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12924