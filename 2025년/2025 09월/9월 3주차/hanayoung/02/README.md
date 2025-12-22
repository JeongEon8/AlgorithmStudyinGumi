# [백준 - G5] 20437. 문자열 게임 2

## ⏰  **time**
90분

## :pushpin: **Algorithm**
슬라이딩 윈도우

## ⏲️**Time Complexity**
$O(T*L)$

## :round_pushpin: **Logic**
1. 각 알파벳별 출현 위치를 담을 리스트 생성
```java
            ArrayList<Integer>[] pos = new ArrayList[26];
            for(int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            for(int i = 0; i < str.length(); i++) {
                pos[str.charAt(i) - 'a'].add(i);
            }
```
2. 등장 횟수가 K보다 작을 경우, 탐색할 이유가 없으므로 continue
3. 0번부터 등장횟수 - k까지 확인하면서, 해당 위치부터 k번 이후까지의 거리를 확인해서 answer[0]에는 최솟값, answer[1]에는 최댓값 확인 후 삽입
```java
            for (ArrayList<Integer> po : pos) {
                if (po.size() < K) {
                    continue;
                }
                for (int j = 0; j <= po.size() - K; j++) {
                    int len = po.get(j+K-1) - po.get(j) + 1;
                    answer[0] = Math.min(answer[0], len);
                    answer[1] = Math.max(answer[1], len);
                }
            }
```
4. 둘 중 하나의 값이 0이거나 Intege.MAX_VALUE라면 할당된 적 없다는 의미므로, 가능한 것이 없어서 -1 할당
```java
            if(answer[0] == Integer.MAX_VALUE || answer[1] == 0) sb.append(-1);
            else sb.append(answer[0]).append(" ").append(answer[1]);
```



## :black_nib: **Review**
- 대박적 어려움.. 지난번에 포기했다가 다시 들이박은건데 대박적 어려움.. 이건 내가 푼 게 아니야.....어려워

## 📡**Link**
- https://www.acmicpc.net/problem/20437
