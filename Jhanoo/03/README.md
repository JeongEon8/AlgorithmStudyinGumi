# [PGS - Lv2] 03_스킬트리

## ⏰**time**

16분

## :pushpin: **Algorithm**

* 문자열 처리
* 구현
* 순서 검증

## ⏲️**Time Complexity**

$O(N \times L \times S)$
`N`은 `skill_trees`의 개수, `L`은 각 스킬트리의 길이, `S`는 `skill`의 길이이다.
각 스킬트리의 문자를 순회하면서 `skill.indexOf(c)`로 선행 스킬 내 위치를 찾기 때문에 전체 시간 복잡도는 $O(N \times L \times S)$이다.

문제 제한에서 `skill`의 길이는 작기 때문에 실질적으로는 $O(N \times L)$에 가깝게 동작한다.

## :round_pushpin: **Logic**

1. 가능한 스킬트리의 개수를 저장할 변수 `cnt`를 선언한다.

   ```java
   int cnt = 0;
   ```

2. 각 스킬트리를 하나씩 확인한다.

   `cur`은 현재 배워야 하는 선행 스킬의 인덱스를 의미한다.

   ```java
   for (String tree : skill_trees) {
       int cur = 0;
       boolean ok = true;
   }
   ```

3. 스킬트리의 각 문자를 순회하면서, 해당 스킬이 선행 스킬 순서에 포함되는지 확인한다.

   ```java
   char c = tree.charAt(i);
   int idx = skill.indexOf(c);
   ```

4. `idx == -1`이면 선행 스킬과 관계없는 스킬이므로 무시하고 넘어간다.

   ```java
   if (idx == -1) continue;
   ```

5. 선행 스킬에 포함된 스킬인데, 현재 배워야 하는 순서보다 뒤의 스킬이라면 순서가 잘못된 것이다.

   예를 들어 `skill = "CBD"`일 때, 아직 `C`를 배워야 하는데 `B`나 `D`가 먼저 나오면 불가능한 스킬트리이다.

   ```java
   if (cur < idx) {
       ok = false;
       break;
   }
   ```

6. 현재 배워야 하는 선행 스킬이 맞다면 `cur`을 증가시켜 다음 선행 스킬을 기다린다.

   ```java
   if (cur == idx) cur++;
   ```

7. 하나의 스킬트리를 끝까지 확인했을 때 `ok`가 `true`라면 가능한 스킬트리이므로 개수를 증가시킨다.

   ```java
   if (ok) cnt++;
   ```

8. 모든 스킬트리를 확인한 뒤 가능한 스킬트리의 개수 `cnt`를 반환한다.

   ```java
   return cnt;
   ```

## :black_nib: **Review**

* 선행 스킬에 포함되지 않은 스킬은 순서에 영향을 주지 않으므로 무시하면 된다.
* 핵심은 현재 배워야 하는 선행 스킬 위치를 `cur`로 관리하고, 그보다 뒤의 스킬이 먼저 나오는 경우를 걸러내는 것이었다.
* `skill.indexOf(c)`를 사용하면 해당 스킬이 선행 스킬에 포함되는지와 몇 번째 순서인지 한 번에 확인할 수 있어 구현이 간단했다.
* 문제 제한이 작기 때문에 현재 방식으로 충분히 해결 가능하지만, `skill`의 길이가 커진다면 문자별 순서를 미리 `Map`에 저장해 `indexOf` 비용을 줄일 수도 있다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/49993
