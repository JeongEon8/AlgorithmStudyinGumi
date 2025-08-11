# \[백준 - 실버 2] 1541. 잃어버린 괄호

## ⏰  **time**

10분

## \:pushpin: **Algorithm**

그리디 + 문자열 파싱

## ⏲️**Time Complexity**

\$O(N)\$

* $N$: 수식 문자열 길이

## \:round\_pushpin: **Logic**

1. 문자열을 왼쪽부터 훑으며 숫자를 `num`에 누적.
2. 구분자(`+` 또는 `-`)를 만나거나 문자열 끝에 도달하면, 지금까지 만든 숫자를 정수로 변환해 누적:

   * 아직 `-`를 본 적이 없다면 **더하기**.
   * 한 번이라도 `-`가 나오면 그 이후 숫자들은 **모두 빼기**.
3. 이유: 최소값을 만들려면 첫 `-` 이후의 모든 덩어리를 괄호로 묶어 한꺼번에 빼면 됨.

```cpp
string s; cin >> s;
int ans = 0; bool minus = false; string num = "";

for (int i = 0; i <= (int)s.size(); i++) {
    if (i == s.size() || s[i] == '+' || s[i] == '-') {
        if (!num.empty()) {
            int x = stoi(num);
            ans += minus ? -x : x;
            num.clear();
        }
        if (i < s.size() && s[i] == '-') minus = true; // 첫 '-' 이후는 전부 뺌
    } else {
        num += s[i];
    }
}
cout << ans;
```

## \:black\_nib: **Review**

* 핵심은 “첫 `-` 이후 모두 빼기”라는 그리디 아이디어 하나!
* 파싱 시 마지막 숫자 처리를 위해 `i == s.size()` 조건을 넣는 게 깔끔했다.

## 📡 Link

[https://www.acmicpc.net/problem/1541](https://www.acmicpc.net/problem/1541)
