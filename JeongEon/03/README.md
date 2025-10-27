
# [백준 - 실버 2] 1182. 부분수열의 합

## ⏰**time**
15분

## :pushpin: **Algorithm**
DFS, 부분집합 완전탐색

## ⏲️**Time Complexity**
$O(2^N)$

## :round_pushpin: **Logic**
1. 부분수열을 재귀적으로 만들며 현재까지의 합 `tmp`를 추적한다.
2. 인덱스 `idx`부터 시작해서 두 가지 선택지를 탐색:
   * 현재 원소를 **선택하지 않고** 다음으로 넘어감
   * 현재 원소를 **선택하고** 합에 더해서 다음으로 넘어감
3. 합이 목표값 `sum`과 같아지는 경우 카운트 증가
4. 공집합은 제외됨 (`idx == N`인 종료조건일 때 sum 비교 X)
```cpp
solve(idx, tmp):
    if idx == N: return

    if tmp + arr[idx] == sum:
        cnt += 1

    solve(idx + 1, tmp)              // 현재 원소 미포함
    solve(idx + 1, tmp + arr[idx])   // 현재 원소 포함
```

## :black_nib: **Review**
* 단순한 부분집합 탐색인데, **공집합은 포함되지 않음**에 주의해야 했다.
* 브루트포스 유형 중 구현이 간결하고 직관적인 예시라서 연습용으로 좋았음.
* DP나 비트마스크로도 응용 가능할 듯!

## 📡 Link
[https://www.acmicpc.net/problem/1182](https://www.acmicpc.net/problem/1182)
