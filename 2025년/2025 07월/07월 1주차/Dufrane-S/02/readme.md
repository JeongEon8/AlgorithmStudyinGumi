# [백준- S4] 1205. 등수 구하기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 실제 등수와 랭킹 리스트에 들어갈 수 있는지 판별할 수 있는 idx를 만들어서 계산
```java
int answer = 1;
            int idx = 1;
            for (int now : scoreList) {
                if (now > score) {
                    answer++;
                    idx++;
                } else if (now == score) {
                    idx++;
                } else {
                    if (idx <= maxList) {
                        System.out.println(answer);
                    } else {
                        System.out.println(-1);
                    }
                    return;
                }
            }
            if (idx <= maxList) {
                System.out.println(answer);
            } else {
                System.out.println(-1);
            }
```

## :black_nib: **Review**
- edge 케이스를 주의

## 📡**Link**
- https://www.acmicpc.net/problem/1205
