# [백준 - S4] 13567. 로봇

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
명령에 따라서 실행한다. 만약 중간에 영역 밖으로 나가게된다면 -1을 출력하고 종료한다.
```java
int dir = 0;
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    String type = st.nextToken();
    int value = Integer.parseInt(st.nextToken());
    if (type.equals("MOVE")) {
        int nextY = y + dy[dir] * value;
        int nextX = x + dx[dir] * value;
        if (nextY < 0 || nextX < 0 || nextY > m || nextX > m) {
            System.out.println(-1);
            return;
        }
        y = nextY;
        x = nextX;
    } else {
        if (value == 0) {
            dir = (dir + 1) % 4;
        } else {
            dir = (dir + 3) % 4;
        }
    }
}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/13567