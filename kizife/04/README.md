# [백준] 2628. 종이자르기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현, 정렬 

## ⏲️**Time Complexity**
212ms

## :round_pushpin: **Logic**
- 가로로 자르는 넘버, 세로로 자르는 넘버를 각각의 리스트에 넣는다.
```java
            if (dir == 0) {
                wList.add(num);
            } else if (dir == 1) {
                hList.add(num);
            }
```

- 전체 길이를 추가하고, 내림차순으로 정렬한다.
- 이때 '가로로 자르는 넘버'는 세로 길이에 영향을 주므로, wList에 h를 추가해야 한다. (반대도 마찬가지)
```java
        wList.add(h);
        wList.add(0);
        hList.add(w);
        hList.add(0);

        Collections.sort(wList, Collections.reverseOrder());
        Collections.sort(hList, Collections.reverseOrder());
```

- 각 요소들 사이 간격을 구하고, 그 중 max값을 추출한다.
```java
        int hLength = 0;
        int maxHLength = 0;
        for (int i = 0; i < wLastIndex; i++) {
            hLength = wList.get(i) - wList.get(i + 1);
            if (maxHLength < hLength) {
                maxHLength = hLength;
            }
        }
```

- max 가로값, 세로값을 곱하여 출력한다.

## :black_nib: **Review**
- wList에 h를 추가해야 하는데, 반대로 w를 추가했었다. 금방 고쳤다.

## 📡**Link**
- https://www.acmicpc.net/problem/2628
