# [PGS - Lv2] 01\_비밀 코드 해독

## ⏰**time**

60분

## :pushpin: **Algorithm**

백트래킹

## ⏲️**Time Complexity**

$$O(\binom{N}{5} \times M)$$

## :round_pushpin: **Logic**

1. 1부터 N까지의 숫자 중 5개를 중복 없이 선택하는 모든 조합을 DFS 백트래킹으로 생성
2. 5개의 숫자가 모두 선택되면, `q[k]` 값들과 각각 몇 개가 일치하는지 카운트한ㄷ.
3. 모든 시도에서 일치하는 개수가 `ans[k]`과 정확히 일치하는 경우, `answer + 1`

```java
static void comb(int start, int idx, int n, int[][] q, int[] ans) {

    if (idx == 5) {

        boolean isPossible = true;
        for(int k = 0; k < q.length; k++) {
            int[] arr = q[k];
            int cnt = 0;

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if (selected[i] == arr[j]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt != ans[k]) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            answer++;
        }

        return;
    }

    for(int i = start; i <= n; i++) {
        selected[idx] = i;
        comb(i + 1, idx + 1, n, q, ans);
    }
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/388352>
