# [PGS - Lv2] 01_테이블 해시 함수

## ⏰**time**

21분

## :pushpin: **Algorithm**

- 정렬
- XOR
- 2차원 배열
- 구현

## ⏲️**Time Complexity**

$O(N \log N + N \times M)$

`N`은 `data`의 행 개수, `M`은 열 개수이다.

먼저 `data`를 정렬하는 데 $O(N \log N)$이 걸린다.

이후 `row_begin`부터 `row_end`까지 각 행의 모든 열을 순회하면서 나머지의 합을 계산한다.

최악의 경우 모든 행과 모든 열을 확인하므로 이 과정은 $O(N \times M)$이다.

따라서 전체 시간 복잡도는 다음과 같다.

```
O(N log N + N × M)
```

## :round_pushpin: **Logic**

1. 문제의 조건에 따라 `data`를 정렬한다.

   `col`번째 컬럼을 기준으로 오름차순 정렬하고, 해당 값이 같다면 첫 번째 컬럼을 기준으로 내림차순 정렬한다.

   ```
   Arrays.sort(data, (a, b) -> {
       if (a[col - 1] == b[col - 1]) {
           return b[0] - a[0];
       }
       return a[col - 1] - b[col - 1];
   });
   ```

2. 문제에서 행 번호는 1부터 시작하므로 `i`번째 행은 배열에서 `data[i - 1]`에 해당한다.

   ```
   for (int i = row_begin; i <= row_end; i++) {
       ...
   }
   ```

3. 각 행에 대해 모든 컬럼 값을 현재 행 번호 `i`로 나눈 나머지를 더해 `S_i`를 계산한다.

   ```
   int sum = 0;
   
   for (int num : data[i - 1]) {
       sum += num % i;
   }
   ```

4. 구한 `S_i` 값을 이전 결과와 XOR 연산한다.

   ```
   answer ^= sum;
   ```

5. `row_begin`부터 `row_end`까지 모든 행을 처리한 뒤 최종 XOR 값을 반환한다.

   ```
   return answer;
   ```

## :black_nib: **Review**

- 정렬 조건을 정확하게 구현하는 것이 핵심인 문제였다.
- `col`은 1-based이므로 실제 배열에서는 `col - 1`을 사용해야 했다.
- 정렬 기준 값이 같은 경우 첫 번째 컬럼을 내림차순으로 정렬해야 하므로 비교 조건을 두 단계로 나눴다.
- 문제의 행 번호 `i`는 1부터 시작하지만 배열 접근은 `data[i - 1]`을 사용해야 했다.
- 정렬이 포함되므로 전체 시간 복잡도는 단순 $O(N)$이 아니라 $O(N \log N + N \times M)$이다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/147354
