# [PGS - lv2] 모음사전

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS, 완전탐색

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

1. 모음(`A, E, I, O, U`)을 이용해 만들 수 있는 모든 문자열을 DFS로 탐색
2. 현재 문자열(curr)이 target과 같아지면, 그때의 순서(cnt)를 answer에 저장하고 멈춤
3. 문자열 길이가 5가 되면 더 이상 탐색하지 않고 종료(`word의 길이` = 1 ~ 5)
4. 각 단계에서 모음을 하나씩 붙이며 탐색을 진행하고, 진행할 때마다 cnt 증가

```java
static void dfs(String curr, String target) {

    if (curr.equals(target)) {
        answer = cnt;
        return;
    }

    if (curr.length() == 5) return;

    for (int i = 0; i < 5; i++) {
        cnt++;
        dfs(curr + arr[i], target);
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12953>
