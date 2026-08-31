# [SWEA - D1] 04_홀수만 더하기

## ⏰**time**

(걸린 시간을 작성해주세요.)

## :pushpin: **Algorithm**

(알고리즘을 작성해주세요.)

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. (풀이 방식을 작성해주세요.)
   ```
   for(int i=0; i<T; i++) {
               int sum = 0;
               for(int j=0; j<10; j++) {    // 10개의 수 입력 
                   int num = sc.nextInt();
                   if(num%2 != 0)
                       sum = sum + num;
               }
               System.out.println("#"+(i+1)+" "+sum);
               sum = 0;
           }
   ```

## :black_nib: **Review**

- (소감을 작성해주세요.)

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
