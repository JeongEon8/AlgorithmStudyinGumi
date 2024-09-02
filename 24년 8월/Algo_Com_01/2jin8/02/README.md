# [SWEA - D3️] 1244. 최대 상금
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 최대 10번 이동할 수 있지만, 숫자판의 개수만큼만 이동하면 최대값을 찾을 수 있음 ⇒ 가지치기
  - `if (change > n) change = n;`
- 이동 가능한 횟수만큼 이동을 끝낸 경우 ⇒ 최대값 갱신 후 종료
- 이동을 끝내지 않은 경우 ⇒ `교환 횟수, 상금` 문자열을 만들어서 해당 경우를 진행했는지 확인하기
  - 진행한 적이 없다면 계속해서 탐색하기
```java
static void dfs(int changeCnt) {
    if (changeCnt == change) {
        max = Math.max(max, getTotal());
        return;
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            swap(i, j);
            String now = new StringBuilder().append(changeCnt).append(",").append(getTotal()).toString();
            if (!visited.contains(now)) {
                visited.add(now);
                dfs(changeCnt + 1);
            }
            swap(i, j); 
        }
    }
}
```

## :black_nib: **Review**
최대 자릿수와 최대 교환 횟수가 적어서 완탐을 생각했다. 그냥 완탐으로 풀면 시간 초과가 발생하므로 가지치기와 방문 확인을 해야 한다.

처음에 2차원 배열로 풀었는데, HashSet을 사용하면 시간을 많이 줄일 수 있다는 것을 알았다. 항상 더 효율적인 방법을 생각하도록 노력해야지..

## 📡**Link**
- [SWEA 1244_최대 상금](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD)
