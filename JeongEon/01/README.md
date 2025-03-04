# [백준 - 실버 4] 2870. 수학숙제
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 숫자인지 확인하고, 만약 0이면 지금 수를 저장한다.
```cpp
while (N--) {
    cin >> str;
    string num;
    for (char c : str) {
        if (c >= '0' && c <= '9') {
            if (num.size() == 1 && num.front() == '0') {
                num = c;
            }
            else {
                num += c;
            }
        }
        else if (!num.empty()) {
            nums.push_back(num);
            num.clear();
        }
    }

    if (!num.empty()) {
        nums.push_back(num);
    }
}
```

## :black_nib: **Review**
- 실버인데... 왜 이렇게 어렵지

## 📡 Link
https://www.acmicpc.net/problem/2870
