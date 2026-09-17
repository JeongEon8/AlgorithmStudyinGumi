# [PGS - LV3] 01\_인사고과

## ⏰**time**

30분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 근무 태도 점수는 내림차순, 동점일 경우 동료 평가 점수는 오름차순으로 정렬
   - 이전 사원들보다 근태 점수가 낮거나 같아지므로, 여태까지 나온 최대 동료 평가 점수(maxPeer)보다 현재 사원의 동료 평가 점수가 작다면 두 점수 모두 자신보다 높은 사원이 존재하는 탈락 조건

2. 탐색 중 탈락 대상이 완호라면 `-1`을 반환합니다.
3. 탈락하지 않은 정상 사원 중, 두 점수의 합이 완호의 총점보다 큰 사원이 있을 때마다 완호의 석차를 1씩 증가

```java
Arrays.sort(scores, (a, b) -> {
    if (a[0] == b[0]) {
        return a[1] - b[1]; // 근태 내림차순
    }
    return b[0] - a[0];  // 동평 오름차순
});

int maxPeer = 0;
int rank = 1;

for(int[] score: scores) {
    if (score[1] < maxPeer) {
        // 탈락자가 완호
        if (score[0] == wanho[0] && score[1] == wanho[1]) {
            return -1;
        }
        continue;
    }

    maxPeer = Math.max(maxPeer, score[1]);

    // 완호보다 점수 높으면
    if (score[0] + score[1] > wanhoSum) {
        rank++;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/152995>
