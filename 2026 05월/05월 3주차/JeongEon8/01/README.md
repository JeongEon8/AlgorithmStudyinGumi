# [PGS - Lv2] 12980_점프와 순간 이동

## ⏰**time**
35분

## :pushpin: **Algorithm**
수학(홀짝)

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 2로 나눴을 때 나머지가 있으면 점프 이동해야하므로, 배터리를 1 더하고 n -1 해서 계산한다.
2. 2로 나눴을 때 나머지가 없으면 순간이동 한다.
   ```cpp
    do {
        if(n%2 != 0) {
            ans++;
            n -= 1;
        }
        else {
            n /= 2;
        }
    } while(n > 0);
   ```

## :black_nib: **Review**
- 오늘은 부처님 오신 날~ 

## 📡 Link
[프로그래머스 Lv2 점프와 순간이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)
