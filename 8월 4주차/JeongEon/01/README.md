# \[백준 - 실버 1] 14889. 스타트와 링크

## ⏰  **time**

25분

## \:pushpin: **Algorithm**

백트래킹(조합) + 완전탐색

## ⏲️**Time Complexity**

\$O!\left(\binom{N}{N/2}\cdot N^2\right)\$

* 팀 구성 조합 수 $\binom{N}{N/2}$
* 각 조합에서 팀 능력 합산 $O(N^2)$

## \:round\_pushpin: **Logic**

1. `team[i]=true`이면 **스타트**, `false`이면 **링크** 팀으로 가정하며 조합을 만든다.
2. 인덱스 `idx`부터 순회하며 `N/2`명이 채워지면 두 팀을 구성한다.
3. 각 팀에 대해 모든 쌍 $(i,j)$에 대해 `score[i][j]`를 누적해 팀 능력치를 계산한다.
4. 두 팀 능력치 차이의 절댓값으로 최소값 `mymin`을 갱신한다.
5. 재귀(백트래킹): 선택 → 재귀 호출 → 선택 해제로 원상 복구.

```cpp
void teamset(int idx, int cnt) {
    if (cnt == N/2) {
        vector<int> A, B; int sa=0, sb=0;
        for (int i=0;i<N;i++) (team[i]?A:B).push_back(i);
        for (int i=0;i<N/2;i++)
            for (int j=0;j<N/2;j++) {
                sa += score[A[i]][A[j]];
                sb += score[B[i]][B[j]];
            }
        mymin = min(mymin, abs(sa - sb));
        return;
    }
    for (int i=idx;i<N;i++) {
        if (team[i]) continue;
        team[i] = true;
        teamset(i+1, cnt+1);
        team[i] = false;
    }
}
```

## \:black\_nib: **Review**

* 조합 생성만 깔끔히 해도 정답.
* 대칭 조합(팀 뒤바꿈)까지 탐색하지만 $N \le 20$라 충분히 통과! 다음엔 `i+1`로 가지치기와 초기 고정 선택으로 절반만 탐색해도 좋을 듯.

## 📡 Link

[https://www.acmicpc.net/problem/14889](https://www.acmicpc.net/problem/14889)
