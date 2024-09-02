# [백준 - 실버 5] 11723. 집합

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
배열

## ⏲️**Time Complexity**
$O(M)$

## :round_pushpin: **Logic**
1. 배열이 true인지 false인지 확인한다.
```cpp
for (int i = 0; i < M; i++) {
    cin >> str;

    if (str == "add") {
        cin >> x;
        if (arr[x] == 0) {   //없으면
            arr[x] = 1;
        }
    }

    else if (str == "remove") {
        cin >> x;
        if (arr[x] == 1) {  //있으면
            arr[x] = 0;
        }

    }
    else if (str == "check") {
        cin >> x;
        if (arr[x] == 0) {   //없으면
            cout << "0\n";
        }
        else {
            cout << "1\n";
        }
    }
    else if (str == "toggle") {
        cin >> x;
        if (arr[x] == 1) {  //있으면
            arr[x] = 0;
        }
        else {
            arr[x] = 1;
        }
    }
    else if (str == "all") {

        for (int k = 1; k <= 20; k++) { arr[k] = 1; }

    }
    else if (str == "empty") {
        memset(arr, 0, sizeof(arr));
    }
}
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/11723
