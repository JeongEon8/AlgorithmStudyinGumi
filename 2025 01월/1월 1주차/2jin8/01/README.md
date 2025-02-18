# [백준- G4] 1091. 카드 섞기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
- 카드 섞기 과정
  - 플레이어들에게 정해진 카드를 줄 수 있는지 확인하기 ⇒ 줄 수 있다면 종료
  - 현재 카드 = `cards[i]`, 현재 카드를 나눠줄 플레이어: `i % 3`
    - 따라서 `P[card] != player`라면 정해진 카드를 나눠줄 수 없는 것!
  - 카드 섞기
- 이때, 원본 배열로 돌아오면 카드 섞기 종료 (실패한 것)
```java
static int shuffle() {
  int cnt = 0;
  while (true) { 
    // 원본 배열로 돌아오면 종료
    if (cnt > 0 && eqaulOrigin())  break;
    
    // 해당 플레이어에게 정해진 카드를 줄 수 있는지 확인하기
    if (check()) return cnt;

    // 카드 섞기
    int[] shuffleCards = new int[N];
    for (int i = 0; i < N; i++) {
      shuffleCards[S[i]] = cards[i];
    }
    cards = shuffleCards.clone();
    cnt++;
  }
  return -1;
}

static boolean check() {
  for (int i = 0; i < N; i++) {
    int card = cards[i]; // 현재 카드
    int player = i % 3; // 현재 카드를 나누줄 플레이어
    // i번 카드를 플레이어 P[i]에게 나눠주지 못하는 경우라면 false
    if (P[card] != player)
      return false;
  }
  return true;
}
```

## :black_nib: **Review**
구현 자체는 간단하지만 문제 이해하는데 시간이 오래 걸렸던 문제.. 

## 📡**Link**
- https://www.acmicpc.net/problem/1091
