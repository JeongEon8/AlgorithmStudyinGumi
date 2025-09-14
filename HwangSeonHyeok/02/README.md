# [백준 - S2] 22941. RPG 마스터 오명진

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학


## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
용사가 마왕의 공격을 몇차례 버틸 수 있을지 계산하고 마왕을 물리치는데 필요한 턴수를 구해서 비교한다.
마왕을 물리치는데 필요한 턴수는 마왕이 회복이 가능한지를 계산하여 가능한경우 회복을 한 hp를 기준으로 계산하고 아닌 경우 기본 hp로 계산하여 계산한다.

```java
static boolean Play() {
    long turn = heroHP / monsterATK;
    if (heroHP % monsterATK != 0) {
        turn++;
    }
    long ddalP = monsterHP % heroATK;
    if (ddalP == 0)
        ddalP += heroATK;
    if (ddalP >= 1 && ddalP <= p) {
        monsterHP += s;
    }
    long requireTurn = monsterHP / heroATK;
    if (monsterHP % heroATK != 0) {
        requireTurn++;
    }
    if (requireTurn <= turn) {
        return true;
    } else {
        return false;
    }
}
```
## :black_nib: **Review**
사칙연산 문제

## 📡**Link**

https://www.acmicpc.net/problem/22941