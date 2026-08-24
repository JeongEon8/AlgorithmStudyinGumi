# [PGS - Lv2] 02_광물 캐기

## ⏰**time**

33분

## :pushpin: **Algorithm**

- Greedy
- 정렬
- 구현

## ⏲️**Time Complexity**

$O(N + G \log G)$

`N`은 실제로 캘 수 있는 광물의 개수이고, `G`는 광물을 5개씩 나눈 그룹의 개수이다.

먼저 실제로 캘 수 있는 광물을 한 번 순회하면서 그룹별 광물 개수를 계산하므로 $O(N)$이 걸린다.

이후 `G`개의 그룹을 피로도가 큰 순서로 정렬하므로 $O(G \log G)$이 걸린다.

마지막으로 각 그룹에 곡괭이를 하나씩 배정하면서 다시 `G`개의 그룹을 순회하므로 $O(G)$이 걸린다.

따라서 전체 시간 복잡도는

```text
O(N + G log G)
```

이다.

`G ≤ N / 5`이므로 큰 관점에서는 $O(N \log N)$으로 볼 수도 있다.

## :round_pushpin: **Logic**

1. 가지고 있는 곡괭이의 총 개수를 계산한다.

   곡괭이 하나는 최대 5개의 광물을 캘 수 있으므로 실제로 캘 수 있는 광물의 개수를 구한다.

   ```java
   int pickCount = picks[0] + picks[1] + picks[2];
   int mineralCount = Math.min(minerals.length, pickCount * 5);
   ```

   곡괭이를 모두 사용하고 나면 이후 광물은 캘 수 없으므로 정렬 대상에서도 제외해야 한다.

2. 광물을 5개씩 하나의 그룹으로 나눈다.

   ```java
   int groupCount = (mineralCount + 4) / 5;
   int[][] groups = new int[groupCount][3];
   ```

   각 그룹에는 다음 정보를 저장한다.

   ```text
   groups[i][0] = diamond 개수
   groups[i][1] = iron 개수
   groups[i][2] = stone 개수
   ```

3. 실제로 캘 수 있는 광물만 순회하면서 각 그룹에 광물 개수를 저장한다.

   ```java
   for (int i = 0; i < mineralCount; i++) {
       int group = i / 5;

       if (minerals[i].equals("diamond")) {
           groups[group][0]++;
       } else if (minerals[i].equals("iron")) {
           groups[group][1]++;
       } else {
           groups[group][2]++;
       }
   }
   ```

4. 각 그룹을 돌 곡괭이로 캤을 때 발생하는 피로도를 계산한다.

   돌 곡괭이의 광물별 피로도는 다음과 같다.

   ```text
   diamond → 25
   iron    → 5
   stone   → 1
   ```

   따라서 그룹의 피로도는 다음과 같이 계산할 수 있다.

   ```java
   int fatigue =
       diamond * 25 +
       iron * 5 +
       stone;
   ```

5. 돌 곡괭이 기준 피로도가 큰 그룹부터 처리하도록 내림차순 정렬한다.

   ```java
   Arrays.sort(groups, (a, b) -> {
       int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
       int fatigueB = b[0] * 25 + b[1] * 5 + b[2];

       return fatigueB - fatigueA;
   });
   ```

   다이아몬드와 철이 많이 포함된 어려운 그룹일수록 나쁜 곡괭이를 사용했을 때 피로도가 크게 증가한다.

   따라서 어려운 그룹에 좋은 곡괭이를 먼저 사용하는 것이 전체 피로도를 줄이는 데 유리하다.

6. 피로도가 가장 높은 그룹부터 순서대로 곡괭이를 배정한다.

   우선 다이아몬드 곡괭이가 있다면 가장 먼저 사용한다.

   ```java
   if (picks[0] > 0) {
       answer += dia + iron + stone;
       picks[0]--;
   }
   ```

   다이아몬드 곡괭이는 모든 광물을 피로도 `1`로 캘 수 있다.

7. 다이아몬드 곡괭이가 없다면 철 곡괭이를 사용한다.

   ```java
   else if (picks[1] > 0) {
       answer += dia * 5 + iron + stone;
       picks[1]--;
   }
   ```

   철 곡괭이의 피로도는 다음과 같다.

   ```text
   diamond → 5
   iron    → 1
   stone   → 1
   ```

8. 다이아몬드와 철 곡괭이가 없다면 돌 곡괭이를 사용한다.

   ```java
   else {
       answer += dia * 25 + iron * 5 + stone;
       picks[2]--;
   }
   ```

9. 모든 그룹에 곡괭이를 배정하고 누적한 최소 피로도를 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

- 처음에는 DP나 DFS로 곡괭이를 선택하는 모든 경우를 탐색하는 방법을 생각했다.
- 하지만 곡괭이는 한 번 사용하면 연속된 광물 5개를 캐야 하므로 광물을 5개 단위로 묶어서 생각할 수 있었다.
- 곡괭이의 총 개수보다 광물이 많은 경우 뒤쪽 광물은 애초에 캘 수 없으므로 실제로 캘 수 있는 범위까지만 그룹화해야 했다.
- 처음에는 각 그룹을 `diamond × 25 + iron × 5 + stone` 값 하나로 저장하고 나중에 광물 개수를 복원하려 했지만, 같은 점수가 서로 다른 광물 구성에서 나올 수 있어 광물 개수를 각각 저장하도록 수정했다.
- 돌 곡괭이 기준 피로도가 클수록 다이아몬드나 철이 많이 포함된 어려운 그룹이므로, 이를 기준으로 내림차순 정렬한 뒤 좋은 곡괭이부터 사용하는 그리디 방식으로 해결했다.
- 문제를 곡괭이 하나가 처리하는 단위인 5개씩 묶어서 바라보는 것이 핵심이었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/172927
