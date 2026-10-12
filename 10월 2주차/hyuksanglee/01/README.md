# [PGS - Lv2] 01_점프와 순간 이동

## ⏰**time**

- 20분

## :pushpin: **Algorithm**
- dp

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 간단하게 n 에서 나누기 2가 가능하면 나누기 2한값을 가지고 오고 아닐경우 -1한 값에서 +1 해준다.
   ```
   public int dfs(int n) {
           if (n == 0) {
               return 0;
           }
   
           if (n % 2 == 0) {
               return dfs(n / 2);
           }
   
           return dfs(n - 1) + 1;
       }
   ```

## :black_nib: **Review**

- 처음에는 배열 만들어서 /2인덱스의 값이랑 -1인덱스의 값에서 +1 값이랑 비교해서 작은 값을 가지고 오게 했는데 이렇게 하니깐 10억이라서 메모리가 초과하고 시간도 초과했음 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12980?language=java
