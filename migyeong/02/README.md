# [백준] 2470. 두 용액


## ⏰ **time**
5분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
O(N log N)

## :round_pushpin: **Logic**
1. 입력 받은 수들을 오름차순으로 정렬
2. 양쪽 끝에서 수부터 비교해서 합의 절대값이 작은 값을 찾음

``` java
while(left < right) {
    int sum = arr[left] + arr[right];
    int absSum = Math.abs(sum);

    if(absSum < minDiff) {
        minDiff = absSum;
        ansL = arr[left];
        ansR = arr[right];
    }

    if(sum < 0) left++;
    else right--;
}
```


## :black_nib: **Review**
for문을 냅다 돌렸다가 시간 초과가 났습니다..

## 📡**Link**
https://www.acmicpc.net/problem/2470
