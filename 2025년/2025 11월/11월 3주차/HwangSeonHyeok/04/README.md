# [백준 - S4] 13413. 오셀로 재배치

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
기본 문자열에서 w인데 목표가 b인거와 기본 문자열이 b와 목표 문자열이 w인 경우를 카운팅한다.  
Math.min(wb,bw)번만큼은 서로 교환을하고 남은 Math.max(wb,bw)-Math.min(wb,bw)만큼 뒤집어주면된다.
즉 Math.min(wb,bw)+Math.max(wb,bw)-Math.min(wb,bw)= Math.max(wb,bw)번 실행하면된다.
```java
int wb = 0;
int bw = 0;
for (int i = 0; i < n; i++) {
    if (source[i] == 'W' && target[i] == 'B')
        wb++;
    if (source[i] == 'B' && target[i] == 'W')
        bw++;
}
sb.append(Math.max(wb, bw)).append('\n');
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/13413