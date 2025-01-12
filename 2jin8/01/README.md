# [백준- G4] 2661. 좋은수열
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(2ⁿn)$

## :round_pushpin: **Logic**
- 문자를 추가하기 전, 문자를 추가해도 좋은 수열이 되는지 확인하기
  - 추가해도 좋은 수열이 된다면 추가하기!
- 새로운 문자를 붙이기 전 수열은 이미 좋은 수열!
  - 따라서 새로 붙여진 문자(=제일 뒤의 문자)를 기준으로 검사하면 됨
```java
static void dfs(int depth, String number) {
    if (ans != null) return;

    if (depth == N) {
        ans = number;
        return;
    }

    for (int i = 1; i <= 3; i++) {
        // 해당 글자를 붙여도 좋은 순열이 되는지 확인
        if (check(number + i))
            dfs(depth + 1, number + i);
    }
}

// 좋은 수열인지 검사하기
static boolean check(String number) {
    int len = number.length();
    // 이미 좋은 수열에 새로운 문자를 하나 붙임
    // 새로운 문자 기준으로 검사해야 함 => 뒤에서부터 확인하기
    for (int i = 1; i <= number.length() / 2; i++) {
        String s1 = number.substring(len - i, len);
        String s2 = number.substring(len - 2 * i, len - i);
        if (s1.equals(s2)) return false;
    }
    return true;
}
```

## :black_nib: **Review**
문자를 완성한 뒤 검사하는 것만 생각했는데 문자를 붙일 때마다 검사를 하는 방법도 있었다..!

## 📡**Link**
- https://www.acmicpc.net/problem/2661
