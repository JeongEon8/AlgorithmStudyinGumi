# \[백준 - 실버 3] 3273. 두 수의 합

## ⏰  **time**

10분

## \:pushpin: **Algorithm**

투 포인터 + 정렬

## ⏲️**Time Complexity**

\$O(N \log N)\$

* 정렬: $O(N \log N)$
* 투 포인터 스캔: $O(N)$

## \:round\_pushpin: **Logic**

1. 수열을 입력받아 정렬한다.
2. 왼쪽 포인터 `left=0`, 오른쪽 포인터 `right=N-1`로 시작.
3. 합이 `total`과 같다면 `result++`, 양쪽 포인터를 각각 안쪽으로 이동.
4. 합이 `total`보다 크면 `right--`, 작으면 `left++`.
5. `left < right`인 동안 반복.

```cpp
sort(arr.begin(), arr.end());
int left = 0, right = N - 1, result = 0;

while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == total) { result++; left++; right--; }
    else if (sum > total) right--;
    else left++;
}
```

## \:black\_nib: **Review**

* 해시로도 풀 수 있지만, 정렬 + 투 포인터가 구현 깔끔하고 실수 적음.
* 같은 쌍을 중복 세지 않도록 `left++`와 `right--`를 함께 이동하는 게 포인트!

## 📡 Link

[https://www.acmicpc.net/problem/3273](https://www.acmicpc.net/problem/3273)
