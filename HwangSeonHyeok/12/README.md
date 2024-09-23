# [백준 - s1] 22939. 쿠키크루

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 브루트 포스

## :round_pushpin: **Logic**

집, 쿠키크루삥뽕의 좌표, 호두, 초콜릿, 베리, 젤리 토핑의 좌표 리스트를 모두 기록해두고 각각의 리스트마다 먹는 순서를 순열로 백트래킹하면서 계산한다.

```java
static void solve(int type, int depth, int pre, int sum) {
    if (sum > min) {
        return;
    }
    List<Point> pList;
    if (type == 0) {
        pList = wList;
    } else if (type == 1) {
        pList = bList;
    } else if (type == 2) {
        pList = cList;
    } else {
        pList = jList;
    }
    Point prePoint = pre == -1 ? home : pList.get(pre);

    if (depth == 3) {
        sum += getDist(prePoint, dest);
        if (sum <= min) {
            min = sum;
            ans = type;
        }
        return;
    }

    for (int i = 0; i < 3; i++) {
        if (!visited[i]) {
            visited[i] = true;
            solve(type, depth + 1, i, sum + getDist(prePoint, pList.get(i)));
            visited[i] = false;
        }
    }
}
```

## :black_nib: **Review**

TSP로도 가능 할거같다.

## 📡**Link**

https://www.acmicpc.net/problem/1205
