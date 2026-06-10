# [PGS - Lv3] 03\_최고의 집합

## ⏰**time**

30min

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

합이 고정되었을 때 원소의 곱이 최대가 되려면, 각 원소의 값이 최대한 비슷해야한다. 따라서 모든 원소를 최대한 균등하게 분배해야 한다.

1. `s < n` 이면 자연수 n개로 합 s를 만들 수 없으므로 `[-1]` 반환
2. `s / n` 값을 모든 원소의 기본값으로 설정
3. `s % n` 만큼의 나머지를 뒤에서부터 1씩 더해줌
4. 결과 배열은 이미 오름차순이므로 그대로 반환

```java
public int[] solution(int n, int s) {
    int[] answer = new int[n];

    int base = s / n;
    int remain = s % n;

    Arrays.fill(answer, base);

    for(int i = n - remain; i < n; i++) {
        answer[i]++;
    }

    if (s < n) return new int[]{-1};
    return answer;
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/12938>
