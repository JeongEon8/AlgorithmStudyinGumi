# [백준 - S1] 18230. 2xN 예쁜 타일링

## ⏰ **time**

40분

## :pushpin: **Algorithm**
- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각각의 타일을 내림차순으로 정렬한다. Collections.reverseOrder()를 사용하기 위해 각 배열들은 Integer타입으로 만들었다.
2*1 타일은 half타일, 2*2 타일을 1개로 기준을 잡는다.  
만약 채워야 하는 길이가 홀수이면 half타일이 홀수개 필요하므로 가장 예쁨 값이 큰 half타일 1개를 우선적으로 배치해야한다. 이후 남은 칸들은 half타일이 2개이상 남아있는 경우 그 다음으로 값이 큰 half타일 2개 또는 2*2타일 1개 중 예쁨 값이 더 큰걸 우선적으로 배치하면된다.
```java
Arrays.sort(half, Collections.reverseOrder());
Arrays.sort(whole, Collections.reverseOrder());
int remain = n;
int hIdx = 0;
int wIdx = 0;
int ans = 0;
if (remain % 2 == 1) {
    ans += half[hIdx++];
    remain--;
}
while (remain > 0) {
    int doubleHalfValue = (hIdx < a - 1) ? half[hIdx] + half[hIdx + 1] : -1;
    int wholeValue = (wIdx < b) ? whole[wIdx] : -1;
    if (doubleHalfValue >wholeValue) {
        ans += doubleHalfValue;
        hIdx += 2;
        remain -= 2;
    } else {
        ans += wholeValue;
        wIdx++;
        remain -= 2;
    }
}
```

## :black_nib: **Review**  
처음에 분기를 나눠서 오류가 많이 났다.  
2*1타일도 짝수개만 필요하게 맞추고 시작하니 분기 조건 잡기도 편해지고 오류없이 해결할 수 있었다.
## 📡**Link**
https://www.acmicpc.net/problem/18230