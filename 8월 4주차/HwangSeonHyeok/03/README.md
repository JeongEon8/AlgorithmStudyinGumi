# [백준 - S2] 5002. 도어맨

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
남자가 들어가면 +1 여자가 들어가면 -1을 차이값에 더한다.  
차이값이 0보다 크면 현제 대기인원과 현제 앞에 있는 사람중 여자가 있으면 여자를 우선 들여보내고 0보다 작으면 남자를 우선 들여보내고 들여보내지 않은 사람을 대기인원으로 한다. 만약 들여보낼 수 없는 상황이면 중단한다.
```java
int diff = 0;
int waiting = line.charAt(0) == 'M' ? 1 : -1;
int ans = 0;
for (int i = 1; i < line.length(); i++) {
    int current = line.charAt(i) == 'M' ? 1 : -1;
    if (diff > 0) {
        diff += Math.min(waiting, current);
        waiting = Math.max(waiting, current);
    } else {
        diff += Math.max(waiting, current);
        waiting = Math.min(waiting, current);
    }
    if (Math.abs(diff) > x) {
        break;
    } else {
        ans++;
    }
    if (i == line.length() - 1) {
        diff += waiting;
        if (Math.abs(diff) <= x)
            ans++;
    }
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/5002