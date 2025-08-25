# [백준- S2] 15658. 연산자 끼워넣기 (2)
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N⋅(N−1)!)$

## :round_pushpin: **Logic**
- 피연산자들의 순서는 고정 → 연산자만 선택하면 됨
  - 순서 중요 & 선택 ⇒ 순열
- 해당 연산자를 사용할 수 있다면 (`used[i] < calc[i]`) 기록하고 다음 연산자 선택하기
- 연산자를 다 선택하면 수식을 계산한 뒤 최댓값, 최솟값 갱신
```java
// 연산자들을 선택하는 것 (순서 의미O) => 순열
public static void choiceCalc(int depth) {
    if (depth == N - 1) { // 피연산자가 N -> 연산자는 N-1
        int total = getTotal();
        minAnswer = Math.min(minAnswer, total);
        maxAnswer = Math.max(maxAnswer, total);
        return;
    }

    for (int i = 0; i < 4; i++) {
        // 사용할 수 있는 연산자를 다 사용한 경우 X
        if (used[i] == calc[i]) continue;

        used[i]++;
        choice[depth] = i;
        choiceCalc(depth + 1);
        used[i]--;
    }
}
```

## :black_nib: **Review**
완전 완탐 문제! 괜찮았다

## 📡**Link**
- https://www.acmicpc.net/problem/15658
