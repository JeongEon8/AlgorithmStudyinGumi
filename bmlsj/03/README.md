# [백준 - Lv2] 튜플

## ⏰  **time**

20분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 스킬을 배워야 하는 순서 번호로 map에 추가

1. 선행 스킬에 포함되지 않은 스킬
무시하고 계속 진행
2. 선행 스킬이면서 현재 배워야 할 순서인 경우 => `tmp++`
3. 선행 스킬이지만 순서가 맞지 않는 경우 => 실패

끝까지 검사 후 실패 조건이 없으면, `cnt` 증가

```java
for (String sk : skill_trees) {
    int tmp = 0;
    boolean check = true;

    for (char ch : sk.toCharArray()) {
        if (map.containsKey(ch) && map.get(ch) == tmp + 1) {
            tmp++;
        } else if (!map.containsKey(ch)) {
            continue;
        } else {
            check = false;
            break;
        }
    }

    if (check) cnt++;
}

```

## :black_nib: Review

## 📡**Link**

- <https://school.programmers.co.kr/learn/courses/30/lessons/49993>
