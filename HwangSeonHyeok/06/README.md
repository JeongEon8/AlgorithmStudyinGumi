# [백준 - s5] 2891. 카약과 강풍

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 그리디

## :round_pushpin: **Logic**

카약이 고장난팀은 -1, 여분이 있는팀은 1로 저장해서 여분이 있는팀은 자신 앞 팀, 뒷 팀 순으로 고장난 팀에게 나눠줄 수 있는지 체크하고 나눠준다. 모든 과정 후 -1인 팀들이 출발하지 못하는 팀이다.

```java
   for (int i = 1; i <= N; i++) {
        if (i - 1 > 0 && kStates[i - 1] == -1 && kStates[i] == 1) {
            kStates[i - 1]++;
            kStates[i]--;
        }
        if (i + 1 <= N && kStates[i + 1] == -1 && kStates[i] == 1) {
            kStates[i + 1]++;
            kStates[i]--;
        }
    }

```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/2891
