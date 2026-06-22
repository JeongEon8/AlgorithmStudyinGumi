# [PGS - lv2] 03. 광물 캐기

## ⏰**time**

30분

## :pushpin: \*\*Algorithm

그리디

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**

1. 실제로 캘 수 있는 광물 수는 `곡괭이 개수 × 5`개까지만 고려
2. 광물을 5개씩 그룹으로 나눠, 각 그룹의 돌 곡괭이 기준 피로도로 계산한다.
3. 피로도가 난이도 순으로 정렬
   - 돌 곡괭이의 피로도가 높음 => 다이아가 많다.
4. 좋은 곡괭이(다이아 → 철 → 돌)를 힘든 그룹에 배정

```java
List<Group> groups = new ArrayList<>();
for(int i = 0; i < maxMinerals; i += 5) {

    int dia = 0, iron = 0, stone = 0;

    for(int j = i; j < i + 5 && j < maxMinerals; j++) {
        String mineral = minerals[j];

        if (mineral.equals("diamond")) {
            dia++;
            iron += 5;
            stone += 25;
        } else if (mineral.equals("iron")) {
            dia++;
            iron++;
            stone += 5;
        } else {
            dia++;
            iron++;
            stone++;
        }
    }
    groups.add(new Group(dia, iron, stone));
}

groups.sort((a, b) -> b.stone - a.stone);
```

```java
for(Group g: groups) {
    if (picks[0] > 0) {
        answer += g.dia;
        picks[0]--;
     } else if (picks[1] > 0) {
        answer += g.iron;
        picks[1]--;
    } else {
        answer += g.stone;
        picks[2]--;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/172927>