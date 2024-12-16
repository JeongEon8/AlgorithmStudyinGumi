# [백준- S2] 18111. 마인크래프트
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 최소 높이, 최대 높이를 구한 뒤 최소 높이 ~ 최대 높이 값을 땅의 높이로 설정하기
  - 깎아야 하는 땅의 개수, 쌓아야 하는 땅의 개수를 구한 뒤 최소 시간(같다면 최대 높이)을 구하면 됨
```java
int ansHeight = 0, ansTime = Integer.MAX_VALUE;
for (int i = minH; i <= maxH; i++) {
  // 쌓아야 하는 블럭의 개수
  int add = 0;
  for (int j = minH; j < i; j++) {
    add += heightInfo[j] * (i - j);
  }

  // 제거해야 하는 블럭의 개수
  int remove = 0;
  for (int j = i + 1; j <= maxH; j++) {
    remove += heightInfo[j] * (j - i);
  }

  // 쌓아야 하는 블럭이 부족하면 다음으로 넘어가기
  if (add > B + remove)
    continue;

  int time = add + remove * 2;
  if (time < ansTime) { // 최소 시간이 걸리는 것 선택하기
    ansTime = time;
    ansHeight = i;
  } else if (time == ansTime) { // 시간이 같으면 높이가 최대인 것 선택하기
    ansHeight = Math.max(ansHeight, i);
  }
}
```

## :black_nib: **Review**
뇌에 힘을 주고 코드를 치자.. 실수 제발 그만

## 📡**Link**
- https://www.acmicpc.net/problem/18111
