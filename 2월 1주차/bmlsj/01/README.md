# [백준 - S4] 20125. 쿠키의 신체 측정

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 심장 위치 탐색

- 심장은 상, 하, 좌, 우가 모두 `*`인 위치

1. 팔 길이 측정

- 왼팔: 심장 위치에서 왼쪽으로 이동
- 오른팔: 심장 위치에서 오른쪽으로 이동

1. 허리 길이 측정
   심장 바로 아래에서 시작하여 아래 방향으로 `*`의 개수를 센다.
   허리의 끝 위치를 `waistEnd`로 저장한다.
2. 다리 길이 측정

- 왼쪽 다리: 허리 끝 바로 아래의 왼쪽 칸에서 시작하여 아래 방향으로 `*` 개수를 센다.

- 오른쪽 다리: 허리 끝 바로 아래의 오른쪽 칸에서 시작하여 아래 방향으로 `*` 개수를 센다.

```java
int heart_x = 0, heart_y = 0;
  for (int i = 1; i < N - 1; i++) {
   for (int j = 1; j < N - 1; j++) {
    if (cookie[i][j] == '*') {
     // 상하좌우가 모두 * 면, 심장
     if (cookie[i - 1][j] == '*' && cookie[i + 1][j] == '*' && cookie[i][j - 1] == '*'
       && cookie[i][j + 1] == '*') {
      heart_x = i;
      heart_y = j;
      break;
     }
    }
   }
   if (heart_x != 0)
    break;
  }

  int leftArm = 0;
  int y = heart_y - 1;
  while (y >= 0 && cookie[heart_x][y] == '*') {
   leftArm++;
   y--;
  }

  int rightArm = 0;
  y = heart_y + 1;
  while (y < N && cookie[heart_x][y] == '*') {
   rightArm++;
   y++;
  }

  int waist = 0;
  int x = heart_x + 1;
  while (x < N && cookie[x][heart_y] == '*') {
   waist++;
   x++;
  }

  int waistEnd = waist + heart_x;
  int leftLeg = 0;
  x = waistEnd + 1;
  y = heart_y - 1;

  while (x < N && cookie[x][y] == '*') {
   x++;
   leftLeg++;
  }

  int rightLeg = 0;
  x = waistEnd + 1;
  y = heart_y + 1;
  while (x < N && cookie[x][y] == '*') {
   x++;
   rightLeg++;
  }

```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/20125](https://www.acmicpc.net/problem/20125)
