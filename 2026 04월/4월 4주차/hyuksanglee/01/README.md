# [프로그래머스 - lv2] 두 원 사이의 정수 쌍

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

원 전체를 다 탐색하면 시간 초과 뜨고 1사분면만 검사해서 *4를 해주면 됨

```java
for (long x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long)r2 * r2 - x * x));
            
            long minY = 0;
            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt((long)r1 * r1 - x * x));
            }
            
            answer += (maxY - minY + 1);
        }
        
        return answer * 4;
    }
```



## :black_nib: **Review**


## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/181187>
