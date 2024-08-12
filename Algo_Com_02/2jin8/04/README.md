# [SWEA - 모의 SW 역량테스트] 2112. 보호 필름
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 현재까지의 약품 투입 횟수가 최소 투입 횟수보다 크다면 탐색 종료하기
  - 어짜피 정답이 아니기 때문에 더이상 할 필요가 없음
- 모든 경우를 다 탐색하면 성능 검사에 통과하는지 확인하기
  - 성능 검사를 통과하면 최소 투입 횟수 갱신하기
- 약품을 투입하지 않는 경우, 투입하는 경우(A, B)를 나눠서 탐색해야 함
```java
static void dfs(int depth, int cnt) {
    if (cnt >= minCnt) {
        return;
    }
    else if (depth == D) {
        if (checkFilm()) {
            minCnt = Math.min(minCnt, cnt);
        }
        return;
    }

    int[] tmp = film[depth].clone();

    // 약품 투입 X
    dfs(depth + 1, cnt);

    // 약품 투입 O (A)
    Arrays.fill(film[depth], 0);
    dfs(depth + 1, cnt + 1);

    // 약품 투입 O (B)
    Arrays.fill(film[depth], 1);
    dfs(depth + 1, cnt + 1);

    // 되돌리기
    film[depth] = tmp.clone();
}
```

## :black_nib: **Review**
가지치기가 중요한 문제였다. 풀이 방법은 잘 떠올렸지만, dfs 메서드를 아예 잘못 작성해서 시간초과가 계속 발생했었다.. 바본가..?

## 📡**Link**
- [SWEA 2112_보호 필름](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu&categoryId=AV5V1SYKAaUDFAWu&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
