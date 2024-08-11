# [SWEA - 모의 SW 역량테스트] 1952. 수영장
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 모든 경우의 수를 다 확인해야 하므로 `1일권`, `1달권`, `3달권`, `1년권`을 구매하는 경우로 나누어서 dfs 탐색하기
```java
static void dfs(int month, int cost) {
    // 12달 다 확인하면 최소 비용 갱신 후 탐색 종료
    if (month > 12) {
        minCost = Math.min(minCost, cost);
        return;
    }

    // 1일권
    dfs(month + 1, cost + costs[0] * monthPlan[month]);

    // 1달권
    dfs(month + 1, cost + costs[1]);

    // 3달권
    dfs(month + 3, cost + costs[2]);

    // 1년권
    dfs(month + 12, cost + costs[3]);
}
```

## :black_nib: **Review**
그리디나 DP로 풀기에는 복잡해 보이고 못 풀 것 같아서 완탐으로 풀었다.

## 📡**Link**
- [SWEA 1952_수영장](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq&categoryId=AV5PpFQaAQMDFAUq&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
