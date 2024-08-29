# [백준 - 골3️] 15683. 감시
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
구현 (+ BFS)

## :round_pushpin: **Logic**
- CCTV 정보를 배열로 저장하기 ⇒ 각 CCTV의 회전 방향을 조합으로 결정하기
- CCTV의 회전 방향을 전부 결정했으면 배열의 값을 변경하기
  - 다른 문제와 다르게 이동해야 하는 방향이 여러 개 ⇒ 이동해야 하는 방향만큼 반복하기
```java
static int checkArea() {
  int cnt = 0;
  int[][] tmp = copyArray(map);
  for (CCTV cctv : cctvList) {
    int dir = cctv.dir;
    switch (cctv.num) {
    case 1:
      cnt += changeMap(tmp, cctv.x, cctv.y, dir);
      break;
    case 2:
      for (int i = 0; i < 2; i++) { // 방향이 2개
        cnt += changeMap(tmp, cctv.x, cctv.y, dir);
        dir = (dir + 2) % 4;
      }
      break;
    case 3:
      for (int i = 0; i < 2; i++) { // 방향이 2개
        cnt += changeMap(tmp, cctv.x, cctv.y, dir);
        dir = (dir + 1) % 4;
      }
      break;
    case 4:
      for (int i = 0; i < 3; i++) { // 방향이 3개
        cnt += changeMap(tmp, cctv.x, cctv.y, dir);
        dir = (dir + 1) % 4;
      }
      break;
    case 5:
      for (int i = 0; i < 4; i++) { // 방향이 4개
        cnt += changeMap(tmp, cctv.x, cctv.y, dir);
        dir = (dir + 1) % 4;
      }
      break;
    }
  }
  return cnt;
}
```

## :black_nib: **Review**
분명 로직이 맞는데 결과가 제대로 안 나와서 거의 1시간 동안 삽질했다. 
알고보니 반복문을 돌려줄 때마다 변수 값을 초기화해야 했는데 하지 않아서 틀렸던 것..
잔실수를 줄여야지..

## 📡**Link**
- https://www.acmicpc.net/problem/15683
