# [PGS - Lv2] 02\_테이블 해시 함수

## ⏰**time**

30분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(n \log n)$

## :round_pushpin: **Logic**

1. col 번째 컬럼 기준 오름차순 정렬
2. 값이 같다면 기본키인 첫 번째 컬럼 기준 내림차순 정렬
3. 정렬 이후 row_begin 부터 row_end 까지 순회하며 S_i 를 계산한다.
   - 각 행의 모든 컬럼 값에 대해 `value % i` 를 누적하여 S_i 를 구하고, 이를 XOR 연산으로 누적한다.

```java
Arrays.sort(data, (a, b) -> {
    if (a[col - 1] == b[col - 1]) {
        return Integer.compare(b[0], a[0]);
    }
    return Integer.compare(a[col - 1], b[col - 1]);
});

List<Integer> bit = new ArrayList<>();
for(int i = row_begin; i <= row_end; i++) {
    int s = 0;
    for(int val: data[i - 1]) {
        s += val % i;
    }

    answer ^= s;
}
```

## :black_nib: **Review**

- 1개 너무 양심없었으니가 하나 더 풀어용

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/147354](https://school.programmers.co.kr/learn/courses/30/lessons/147354)
