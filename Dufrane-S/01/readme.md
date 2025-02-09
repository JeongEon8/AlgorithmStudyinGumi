# [백준 - S2] 2512. 예산

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 이분탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
이분탐색하면서 예산을 계산해 본다.

```java
 while(start<end) {
                int now = (start + end) / 2;
                sum=0;
                for (int yesan : yesans) {
                    sum += Math.min(now, yesan);
                }
                if(sum<total){
                    start=now+1;
                    answer=now;
                } else if (sum==total) {
                    answer=now;
                    break;
                } else {
                    end=now;
                }
            }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/2512
