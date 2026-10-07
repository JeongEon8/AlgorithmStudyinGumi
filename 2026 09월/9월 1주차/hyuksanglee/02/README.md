# [PGS - Lv2] 02_피보나치 수

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 피보나치 수

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 재귀 함수를 사용해 n-1, n-2의 피보나치 값을 구한다.
2. n이 0 또는 1이 되면 각각 0과 1을 반환한다.
3. 이미 계산한 값은 arr 배열에 저장해 두고, 같은 값이 다시 필요할 경우 재귀 호출 없이 저장된 값을 반환한다.
4. 새로운 값은 pbc(n-1) + pbc(n-2)로 계산하고, 문제 조건에 따라 1234567로 나눈 나머지를 저장한다.
   ```
   public int pbc(int n){
           if(n == 0){
               return 0;
           }
           if(n == 1){
               arr[n] = 1;
               return 1;
           }
           
           if(arr[n] != 0){
               return arr[n];
           }
   
           arr[n] = (pbc(n - 1) + pbc(n - 2))%1234567;
           return arr[n];
       }
   ```

## :black_nib: **Review**

- 왜 피보나치 수는 1234567을 나눈 나머지를 반영하는거지?
=> 단지 숫자가 커져서 int,long에 담지를 못해서라고 하네요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12945
