# [PGS - Lv2] 03_타겟 넘버
## ⏰**time**
1시간

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N*N)$ 

## :round_pushpin: **Logic**
1. 더하기, 빼기를 반복하여 만들수 있는 경우의 수는 $2^N$ 이다.
   ```cpp
    if (index == numbers.size()){
        if (sum == target) {
            answer++;
        }
        return;
    }
    DFS(numbers, target, sum + numbers[index], index + 1);
    DFS(numbers, target, sum - numbers[index], index + 1);
   ```

## :black_nib: **Review**
-

## 📡 Link
[프로그래머스 Lv2 타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)
