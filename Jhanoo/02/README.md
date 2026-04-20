# [프로그래머스 - Lv2] 선인장 숨기기

## ⏰**time**

56분

## :pushpin: **Algorithm**

- 슬라이딩 윈도우
- 모노톤 덱 (Deque)
- 2차원 구간 최소값

## ⏲️**Time Complexity**

$O(mn)$

## :round_pushpin: **Logic**

1. 물방울이 떨어지는 시간을 `dropTime[x][y]`에 기록합니다.  
   `drops`의 i번째 원소는 시간 `i+1`에 떨어지므로, 해당 칸에 `i+1`을 저장하고 한 번도 떨어지지 않은 칸은 `INF`로 둡니다.

```java
int[][] dropTime = new int[m][n];
for (int i = 0; i < m; i++) Arrays.fill(dropTime[i], INF);
for (int i = 0; i < drops.length; i++) {
    int x = drops[i][0], y = drops[i][1];
    dropTime[x][y] = i + 1;
}
```

2. 각 행마다 너비 `w` 슬라이딩 윈도우의 최소값을 모노톤 덱으로 구해 `rowMin`을 만듭니다.  
   `rowMin[i][j]`는 `(i행, j~j+w-1)` 구간의 최소 낙하 시간입니다.

```java
while (!dq.isEmpty() && dropTime[i][dq.peekLast()] >= dropTime[i][j]) dq.pollLast();
dq.offerLast(j);
while (!dq.isEmpty() && dq.peekFirst() <= j - w) dq.pollFirst();
if (j >= w - 1) rowMin[i][j - w + 1] = dropTime[i][dq.peekFirst()];
```

3. `rowMin`에 대해 열 방향으로 높이 `h` 슬라이딩 윈도우 최소값을 다시 구하면,  
   `rectMin[i][j]` = `(i,j)`를 좌상단으로 하는 `h x w` 직사각형의 최소 낙하 시간(= 가장 먼저 맞는 시간)이 됩니다.

```java
while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) dq.pollLast();
dq.offerLast(i);
while (!dq.isEmpty() && dq.peekFirst() <= i - h) dq.pollFirst();
if (i >= h - 1) rectMin[i - h + 1][j] = rowMin[dq.peekFirst()][j];
```

4. 모든 배치 위치를 순회하며 `rectMin`을 확인합니다.
   - `INF`가 하나라도 있으면 물방울을 전혀 맞지 않는 배치이므로 즉시 해당 좌표를 반환
   - 없으면 `firstHitTime`이 최대가 되는 좌표(가장 늦게 처음 맞는 위치)를 정답으로 선택

## :black_nib: **Review**

- 이게 레벨 2라고?? 너무 어려운데..
- 처음에 슬라이딩 윈도우 사용 안하고 선인장 구역을 칸마다 확인했더니 시간초과가 났다. 시간복잡도가 $O(mnwh)$ 가 되어서 그런가보다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/468379
