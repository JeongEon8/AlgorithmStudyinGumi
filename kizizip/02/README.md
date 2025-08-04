# [백준] 9095. 1, 2, 3 더하기 


## ⏰ **time**
15분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(1)

## :round_pushpin: **Logic**
1. 1, 2, 3을 만들 수 있는 경우의 수를 미리 `arr`에 담아준다.
2. `arr[j] = arr[j-1] + arr[j-2] + arr[j-3];`니까.. 그냥 그렇게 해준다...
3. arr의 크기는 암만 커봐야 int[12]이므로 그렇게 생성해 줬음...


## :black_nib: **Review**
쉽다..

## 📡**Link**
https://www.acmicpc.net/problem/9095
