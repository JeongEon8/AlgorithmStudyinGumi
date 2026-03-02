# [백준 - S4] 23842. 성냥개비

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 백트래킹
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
합이 100이하가 될때 합에 사용하는 성냥개비 수를 카운팅하여 n과 같으면 출력한다.  
이때 10보다 작은경우 앞에 0을 붙여주는 처리를 한다.
```java
static int[] matches = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6, 6 };
static int n;

static boolean isAns(int a, int b, int cnt) {
    int sum = a + b;
    cnt += matches[sum / 10] + matches[sum % 10];
    if (cnt == n) {
        StringBuilder sb = new StringBuilder();
        String strA = a < 10 ? "0" + Integer.toString(a) : Integer.toString(a);
        String strB = b < 10 ? "0" + Integer.toString(b) : Integer.toString(b);
        String strSum = sum < 10 ? "0" + Integer.toString(sum) : Integer.toString(sum);
        System.out.println(strA + "+" + strB + "=" + strSum);
        return true;
    }
    return false;
}

static boolean solve(int depth, int a, int b, int cnt) {
    if (a + b > 100) {
        return false;
    }
    if (depth == 4) {
        return isAns(a, b, cnt);
    }

    for (int i = 0; i < 10; i++) {
        if (depth < 2) {
            if (solve(depth + 1, a * 10 + i, b, cnt + matches[i])) {
                return true;
            }
        } else {
            if (solve(depth + 1, a, b * 10 + i, cnt + matches[i])) {
                return true;
            }
        }
    }
    return false;

}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/23842