# [SWEA - 모의 SW 역량테스트] 5644. 무선 충전
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- 사용자 A, B를 이동시키기
- `A만 충전 영역에 들어간 경우`, `B만 충전 영역에 들어간 경우`, `A와 B 모두 충전 영역에 들어간 경우`로 나눠서 충전값 계산하기
- A와 B가 모두 충전 영역에 들어가면 같은 배터리 영역에 들어갔는지 확인하기
  - 주어지는 배터리 정보가 최대 8개 ⇒ 완탐으로 최대 충전값 구하기
```java
for (int j = 0; j < A; j++) {
  Battery battery = batteries[j];
  // A 확인
  if (Math.abs(battery.point.x - userA.x) + Math.abs(battery.point.y - userA.y) <= battery.c) {
    bA.add(j); // 충전 범위 안에 들어가면 저장하기
  }
  // B 확인
  if (Math.abs(battery.point.x - userB.x) + Math.abs(battery.point.y - userB.y) <= battery.c) {
    bB.add(j);
  }
}

// A만 충전 영역에 들어간 경우
int max = 0;
if (bA.size() != 0 && bB.size() == 0) {
  max = batteries[bA.get(0)].p;
  for (int k = 1; k < bA.size(); k++) {
    max = Math.max(max, batteries[bA.get(k)].p);
  }
  total += max;
}
// B만 충전 영역에 들어간 경우
else if (bA.size() == 0 && bB.size() != 0) {
  max = batteries[bB.get(0)].p;
  for (int k = 1; k < bB.size(); k++) {
    max = Math.max(max, batteries[bB.get(k)].p);
  }
  total += max;
}
// A와 B 모두 충전 영역에 들어간 경우
else if (bA.size() != 0 && bB.size() != 0) {
  max = 0;
  // 하나씩 비교해서 최대 충전량 구하기
  for (int k = 0; k < bA.size(); k++) {
    for (int l = 0; l < bB.size(); l++) {
      // A와 B가 동일한 충전 영역에 들어간 경우
      if (bA.get(k) == bB.get(l)) {
        max = Math.max(max, batteries[bA.get(k)].p); // 하나의 배터리 성능을 더하기 (각자 나눠 가지므로.. p/2 + p/2 = p)
      }
      // A와 B가 다른 충전 영역에 들어간 경우
      else {
        max = Math.max(max, batteries[bA.get(k)].p + batteries[bB.get(l)].p); // 각 배터리의 성능을 더하기
      }
    }
  }
  total += max; // 최대 충전량 더하기
}
```

## :black_nib: **Review**
처음에 A와 B가 동일한 배터리 영역에 들어가는 경우를 생각하지 못하고 더럽게 코드를 작성해서 그냥 버렸다ㅎ..  <br/>
결국 원래 생각을 버리고 [다른 분의 아이디어](https://gogigood.tistory.com/41)를 참고해서 문제를 풀었다. 항상 복잡하게 생각해서 더 꼬이는 것 같은 느낌? 다시 풀어봐야 될 듯..

## 📡**Link**
- [SWEA 5644_무선 충전](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo)
