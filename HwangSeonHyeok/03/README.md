# [백준 - S4] 33042. 이변마작 1

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
만수패는 0, 통수패는 1, 삭수패는 2, 자패는 3으로 인덱스를둔 2차원 배열에다가 각 패들이 나온 수를 기록한다.  
만약 5번째 수가 나온다면 그 패가 몇번째 패였는지 출력한다.
```java
for (int i = 1; i <= n; i++) {
    String str = st.nextToken();
    int num = (int) (str.charAt(0) - '0');
    char suit = str.charAt(1);
    int suitIdx = 0;
    if (suit == 'm') {
        suitIdx = 0;
    } else if (suit == 'p') {
        suitIdx = 1;
    } else if (suit == 's') {
        suitIdx = 2;
    } else {
        suitIdx = 3;
    }
    tiles[suitIdx][num]++;
    if (tiles[suitIdx][num] > 4) {
        ans = i;
        break;
    }
}
```

## :black_nib: **Review**
맵을 쓰는걸 의도한것 같은데 배열로 푸는게 더 빠른거 같다.
## 📡**Link**

https://www.acmicpc.net/problem/33042
