# [백준 - 실버 2] 10819. 차이를 최대로

## ⏰**time**

20분

## :pushpin: **Algorithm**

브루트포스, 백트래킹, 순열

## ⏲️**Time Complexity**

$O(N!)$

* 순열의 모든 경우를 탐색하며, 각 경우마다 $O(N)$ 연산 수행

## :round_pushpin: **Logic**

1. 크기가 N인 수열을 입력받고, 순열을 만들 수 있는 모든 경우를 탐색한다.
2. 백트래킹 방식으로 수열의 모든 순서를 생성하며, 방문 여부를 체크.
3. 하나의 순열이 완성되면 인접 원소 간의 절댓값 합을 계산한다.
4. 계산된 합 중 최대값을 저장해 최종적으로 출력한다.

```
solve():
    if v.size() == N:
        tmp_sum = sum of abs(v[i+1] - v[i])
        result = max(result, tmp_sum)
        return

    for i = 1 to N:
        if not visited[i]:
            visited[i] = true
            v.push_back(n[i])
            solve()
            v.pop_back()
            visited[i] = false
```

⚠️ 주의: 배열 인덱스를 `1`부터 사용하므로 크기 설정에 주의 필요

## :black_nib: **Review**

* 수가 8 이하이기 때문에 시간복잡도 $O(N!)$인 브루트포스도 무난히 통과함.
* 순열을 탐색할 때 STL의 `next_permutation`을 사용해도 되고, 백트래킹으로 직접 짜도 좋음.
* 조합보다 순열 생성이 더 까다로울 수 있는데, 이 문제를 통해 백트래킹 구조를 연습하기에 아주 적절했다.

## 📡 Link

[https://www.acmicpc.net/problem/10819](https://www.acmicpc.net/problem/10819)
