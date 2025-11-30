# [백준 - S2] 2859. 별 관찰

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 구현
- 브루트포스 알고리즘
- 정수론
- 시뮬레이션


## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
날과 시간을 분으로 치환한다.  
더 반짝이는 간격이 큰걸 기준으로 충분히 많은 싸이클동안 같이 반짝이는지 확인한다.
```java
static long getFirstMeet(long first, long second, int firstCycle, int secondCycle) {
    if (secondCycle > firstCycle) {
        return getFirstMeet(second, first, secondCycle, firstCycle);
    }
    int cycle = 0;
    while (cycle < maxCycle) {
        long current = first + (long)firstCycle * cycle;
        if (current >= second && (current - second) % secondCycle == 0) {
            return current;
        }
        cycle++;
    }

    return -1;
}
```  


## :black_nib: **Review**
## 📡**Link**
https://www.acmicpc.net/problem/2859