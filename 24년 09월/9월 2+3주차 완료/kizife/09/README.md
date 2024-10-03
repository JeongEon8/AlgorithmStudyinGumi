# [백준] 15686. 치킨 배달 

## ⏰  **time**
2시간 

## :pushpin: **Algorithm**
브루트포스, 백트래킹 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
        // 치킨집을 선택하는 조합 탐색
        for (int i = start; i < chicken.size(); i++) {
            if (!visit[i]) {  // 아직 방문하지 않은 치킨집 
                visit[i] = true;  // 방문 표시
                save.add(chicken.get(i));  // 선택한 치킨집 저장
                find(depth+1, i+1);  // 깊이+1
                save.remove(save.size() - 1);  // 선택 취소 (백트래킹)
                visit[i] = false;  // 방문 취소
            }
        }
```

- 치킨집 선택 조합 찾기 
```java
        // 남길 치킨집 m개를 모두 선택 완료시
        if (depth == m) {
            int sum = 0;  // 각 집에서 치킨집까지의 최소 거리 저장할 합 
            for (int[] i : house) {
                int min = Integer.MAX_VALUE; 
                for (int[] j : save) {  // 선택된 치킨집들에 대해 반복
                    int a = Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);  // 치킨 거리 계산
                    min = Math.min(min, a);  // 최소 거리 갱신
                }
                sum += min;
            }
            result = Math.min(result, sum);  // 현재까지의 최소 치킨 거리 갱신
            return;
        }
```

## :black_nib: **Review**
- 미루고 미루던 치킨 배달... 나중에 다시 풀어야겠다... 

## 📡**Link**
- https://www.acmicpc.net/problem/15686
