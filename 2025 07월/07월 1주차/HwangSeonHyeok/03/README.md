# [백준 - S4] 32653. 흑백 요리사

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학
- 정수론
## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
even하게 구워야하므로 각각의 두께*2의 시간을 구워야한다. 모두가 even하게 구워지려면 굽는 시간의 최소공배수를 구하면 된다.  
각각의 굽는 시간을 소인수분해하여 최소공배수를 구한다.
```java
int[] arr = new int[51];
for (int i = 0; i < n; i++) {
    int time = Integer.parseInt(split[i]) * 2;
    int[] tmpArr = new int[51];
    int tmpTime = time;
    for (int j = 2; j * j <= time; j++) {
        while (tmpTime % j == 0) {
            tmpArr[j]++;
            tmpTime /= j;
        }
    }
    if (tmpTime > 1) {
        tmpArr[tmpTime]++;
    }
    for (int j = 2; j <= 50; j++) {
        arr[j] = Math.max(arr[j], tmpArr[j]);
    }
}
long ans = 1;
for (int i = 2; i <= 50; i++) {
    if (arr[i] > 0) {
        for (int j = 0; j < arr[i]; j++) {
            ans *= i;
        }
    }
}
```

## :black_nib: **Review**
소인수 분해로 최소공배수 구하는 법을 까먹어서 찾아봤습니다
## 📡**Link**

https://www.acmicpc.net/problem/32653