# [PGS - Lv2] 01\_비밀 코드 해독

## ⏰**time**

60분

## :pushpin: **Algorithm**

백트래킹

## ⏲️**Time Complexity**

$$O(\binom{N}{5} \times M)$$

## :round_pushpin: **Logic**

문자열 조각내기: 입력받은 단위 cnt($1$부터 $N/2$까지) 크기만큼 문자열을 연속해서 잘라 배열(또는 리스트)에 저장연속 중복 탐색 및 압축:첫 번째 조각을 기준(prev)으로 잡고, 다음 조각들과 비교하며 순회이전 조각과 같으면: 연속 카운트(count)를 $1$ 증가이전 조각과 다르면: 지금까지 센 카운트와 기준 조각을 결과 문자열에 추가하고, 현재 조각을 새로운 기준(prev)으로 업데이트 및 카운트 초기화잔여 조각 처리: 반복문 종료 후 처리되지 않고 남아있는 마지막 조각과 카운트를 결과 문자열 뒤에 최종 합산최솟값 갱신: 각 단위별로 압축된 문자열의 길이 중 최댓값/최솟값을 비교하여 정답 갱신

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
