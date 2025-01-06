# [백준] 20166. 문자열 지옥에 빠진 호석 


## ⏰ **time**
90분 

## :pushpin: **Algorithm**
DP, 그래프 이론

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
모든 좌표값에 대해서, 단어의 첫글자와 동일하면 dfs를 시작한다.
```java
for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    totalCount += dfs(i, j, word, 1); // 첫 문자 일치하면 dfs 시작
                }
            }
        }
```

다음 좌표의 경우 범위를 벗어나면, 반대편으로 이동하도록 계산.
다음 좌표값 = 내가 구하려는 단어 철자일 경우 다음 dfs를 실행
```java
            int nx = (x + dx[i] + n) % n;
            int ny = (y + dy[i] + m) % m;

            if (arr[nx][ny] == word.charAt(idx)) {
                count += dfs(nx, ny, word, idx + 1);
            }
```

```java
        // 미리 계산해둔 결과 있으면 반환 
        String key = x + "," + y + "," + idx;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // 마지막 문자까지 도달하면 +1
        if (idx == word.length()) {
            return 1;
        }
```

## :black_nib: **Review**
내가 어려워하는 DP...로직 자체는 내 것이었는데, DP를 못 해서 이 부분으 인터넷의 힘을 많이 빌렸다.

## 📡**Link**
https://www.acmicpc.net/problem/20166 
