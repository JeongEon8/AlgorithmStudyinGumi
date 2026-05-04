# [PGS - Lv2] 광물 캐기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 정렬
- 그리디

## ⏲️**Time Complexity**

$O(N * log * N)$

N은 canMineSize/5

## :round_pushpin: **Logic**

광물을 5개씩 묶어 그룹을 만들고, 각 그룹에서 diamond, iron, stone의 개수를 센다.
이후 곡괭이로 캘 수 있는 최대 개수까지만 고려하여 그룹 리스트를 만든다.
각 그룹을 diamond > iron > stone 순으로 내림차순 정렬하여, 더 많은 피로도를 유발하는 그룹이 앞에 오도록 한다.
정렬된 그룹을 순회하면서 다이아, 철, 돌 곡괭이 순으로 사용해 피로도를 계산한다.

```java
        for(int i = 0; i < canMineSize; i += 5){
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5 && j < canMineSize; j++){
                if(minerals[j].equals("diamond")) dia++;
                if(minerals[j].equals("iron")) iron++;
                if(minerals[j].equals("stone")) stone++;
            }
            mineGroups.add(new MineGroup(dia, iron, stone));
        }
        Collections.sort(mineGroups);

        for(MineGroup m : mineGroups){
            if(picks[0] > 0){
                answer += m.dia + m.iron + m.stone;
                picks[0]--;
            }else if(picks[1] > 0){
                answer += (m.dia * 5) + m.iron + m.stone;
                picks[1]--;
            }else{
                answer += (m.dia * 25) + (m.iron * 5) + m.stone;
                picks[2]--;
            }
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/172927
