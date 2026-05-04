# [PGS - LV2] 05\_단속카메라

## ⏰**time**

30분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N log N)$

## :round_pushpin: **Logic**

1. 차량 경로를 진출 지점 기준으로 오름차순 정렬
2. 현재 카메라가 그 차량을 못 찍으면 그 차량의 진출 지점에 카메라 설치
3. 카메라 설치 횟수 누적

```java
// 나가는 지점 기준 정렬
Arrays.sort(routes, (a, b) -> a[1] - b[1]);
int camera = Integer.MIN_VALUE;

for(int[] r: routes) {
    if (camera < r[0]) {
        camera = r[1];
        answer++;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42884>
