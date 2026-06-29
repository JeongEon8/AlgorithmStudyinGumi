# [SWEA - D3] 01_부분 수열의 합

## ⏰**time**

50분

## :pushpin: **Algorithm**

dfs

## ⏲️**Time Complexity**

$O(2^N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 끝까지 탐색했을 때 합계가 K와 같다면 1을 반환, 아니라면 0을 반환
2. 현재까지의 합인 sum이 K보다 크다면 앞으로도 안 될 경우이므로 0 반환
3. 현재의 값을 선택하는 경우와 선택하지 않는 경우 두 갈래로 나누어서 진행
   ```
int dfs(const std::vector<int>& arr, int idx, int sum, int K) {

    if (idx == static_cast<int>(arr.size())) {

        return (sum == K) ? 1 : 0;

    }



    if (sum > K) {

        return 0;

    }



    return dfs(arr, idx + 1, sum + arr[idx], K)

         + dfs(arr, idx + 1, sum, K);

}
   ```

## :black_nib: **Review**

- 다른 방법으로 접근했다가 좀 오래 걸렸다..! dfs 다시 친해지자...

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
