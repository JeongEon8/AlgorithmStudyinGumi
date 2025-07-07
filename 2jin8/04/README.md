# [백준- S3] 1072. 게임
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(logn)$

## :round_pushpin: **Logic**
- 추가로 하는 게임의 횟수 찾기
- Z가 바뀌면 추가 게임 횟수 줄이기 & 기록
- Z가 바뀌지 않으면 추가 게임 횟수 늘리기
```java
public static void binarySearch(int left, int right) {
    int ans = -1;
    while (left <= right) {
        int mid = (left + right) / 2; // 추가로 하는 게임의 횟수
        int newX = X + mid;
        int newY = Y + mid;
        int newZ = (int) (((long) newY * 100) / newX);

        // Z가 바뀌는 경우, 추가 게임 횟수 줄이기
        if (Z != newZ) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    System.out.println(ans);
}
```

## :black_nib: **Review**
double 연산 주의하기

## 📡**Link**
- https://www.acmicpc.net/problem/1072
