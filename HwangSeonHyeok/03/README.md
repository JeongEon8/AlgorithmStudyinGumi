# [백준 - S1] 16457. 단풍잎 이야기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 백트래킹


## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**
각각의 퀘스트에 필요한 스킬들을 비트마스킹으로 저장한다.
```java
for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int questMask = 0;
			for (int j = 0; j < k; j++) {
				int skill = Integer.parseInt(st.nextToken());
				questMask |= (1 << (skill - 1));
			}
			quests[i] = questMask;
		}
```  
각 조합의 비트를 파라미터로 사용하는 백트래킹을 진행하여 가장 많이 해결할 때의 퀘스트 수를 저장한다.
```java
static void solve(int start, int depth, int mask) {
    if (depth == n) {
        int currentCnt = 0;
        for (int questMask : quests) {
            if ((mask & questMask) == questMask) {
                currentCnt++;
            }
        }
        if (currentCnt > ans) {
            ans = currentCnt;
        }
        return;
    }
    if ((n - depth) > (2 * n - start + 1))
        return;
    for (int i = start; i <= 2 * n; i++) {
        solve(i + 1, depth + 1, mask | (1 << (i - 1)));
    }
}
```

## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/16457