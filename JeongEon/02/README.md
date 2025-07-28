# [백준 - 골드 5] 5467. 용액

## ⏰  **time**
30분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O((N))$

## :round_pushpin: **Logic**
1. 왼쪽 포인터와 오른쪽 포인터를 각각 0, N-1으로 설정한다. (탐색배열이 오름차순이라는 가정)
2. 만약 합한 절대값이 양수일 경우 오른쪽 포인터를 -1 하고 음수일 경우 왼쪽 포인터를 +1한다.
3. 계속해서 반복 후, 왼쪽 포인터가 오른쪽 포인터를 앞지르거나 같을 때 그만둔다.
```cpp
    while (left < right) {
        int sum = input[left] + input[right];
        if (abs(sum) <= compareSum) {
            compareSum = abs(sum);
            answerA = input[left];
            answerB = input[right];
        }

        if (sum > 0) {
            right--;
        }
        else {
            left++;
        }
    }
```

## :black_nib: **Review**
- 첫번째 시도는 완탐으로 풀었는데 시간초과였다.
- 그래서 투포인터로 해봤다. 근데 왜 이게 이분탐색인걸까...

## 📡 Link
https://www.acmicpc.net/problem/2467
