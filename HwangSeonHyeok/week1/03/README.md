# [백준 - S4] 31797. 아~파트 아파트

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**

배열 각각의 index마다 자기 뒤에 자신과 같은 숫자를 세다가 처음으로 다른 숫자가 나오면 diff에 그 다른 숫자를 기록해두고 3번째 종류의 숫자가 나오면 break하고 최대치와 비교한다.

```cpp
    for (int i = 1; i <= m; i++) {
        int num1, num2;
        cin >> num1 >> num2;
        //pair(손의높이, 사람번호)로 vector에 저장
        vec.push_back(make_pair(num1, i));
        vec.push_back(make_pair(num2, i));
    }

    //손의 높이인 first를 기준으로 sort
    sort(vec.begin(), vec.end());

    //(n> 손의 수)인 경우가 있어 (n-1)%손의수가 답이다.
    cout << vec[(n - 1) % (m * 2)].second;
```

## :black_nib: **Review**

- 처음에 아파트 층수가 1바퀴 이상 돌 것이란 생각을 안 해 vec[n-1]을 답으로 제줄해 틀렸다..

## 📡**Link**

- https://www.acmicpc.net/problem/31797
