# [백준- G5] 번호. 제목
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 하나의 용액을 결정하고 투포인터를 사용해서 나머지 두 용액 고르기
  - `second`: 왼쪽 → 오른쪽, `third`: 오른쪽 → 왼쪽
- 특성값이 0보다 작으면 더 큰 값을 더해야 하므로 `second++`
- 특성값이 0보다 크면 더 작은 값을 더해야 하므로 `third--`
```java
// 용액 한 개 고르기(first) & 투포인터 사용해서 나머지 두 용액(second, third) 고르기
for (int first = 0; first < N; first++) {
    int second = 0, third = N - 1;
    while (second < third) {
        // 같은 용액을 선택할 수 없음
        if (second == first) {
            second++;
            continue;
        } else if (third == first) {
            third--;
            continue;
        }

        // 특성값 구한 뒤, 최소값이랑 비교
        long total = values[first] + values[second] + values[third];
        if (Math.abs(total) < minTotal) {
            minTotal = Math.abs(total);
            answer[0] = values[first];
            answer[1] = values[second];
            answer[2] = values[third];
        }

        // 0이 되면 바로 출력 후 종료
        if (total == 0) {
            Arrays.sort(answer);
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
            return;
        }
        else if (total < 0) second++; // 음수면 더 큰 값을 더하도록
        else third--; // 양수면 더 작은 값을 더하도록
    }
}
```

## :black_nib: **Review**
long을 사용해야 하는 일 있을 때 연산 실수하니까 되도록이면 다 long으로 사용하도록 하자

## 📡**Link**
- https://www.acmicpc.net/problem/2473
