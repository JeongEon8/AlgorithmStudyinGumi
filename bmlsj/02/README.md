# [PGS - lv2] 02. n^2 배열 자르기

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 0번째 줄: `[0번]` `[1번]` `[2번]` `[3번]`
- 1번째 줄: `[4번]` `[5번]` `[6번]` `[7번]`
- 2번째 줄: `[8번]` `[9번]` `[10번]` `[11번]`

일때, 6번 상자는 몫이 1이고 나머지가 2인 (1, 2) 자리에 위치

- 해당 위치는 `k/n`번째 행, `k%n`번째 열
- 행과 열 중에 큰 값을 배열에 넣어준다.

```java
public int[] solution(int n, long left, long right) {

    int[] answer = new int[(int)(right - left + 1)];
    int idx = 0;

    for(long k = left; k <= right; k++) {

        long i = k / n;
        long j = k % n;

        if (j < i) {
            answer[idx++] = (int) i + 1;
        } else {
            answer[idx++] = (int) j + 1;
        }
    }

    return answer;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/87390?language=java>
