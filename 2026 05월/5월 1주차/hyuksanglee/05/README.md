# [PGS - lv3] 05.정수 삼각형

## ⏰**time**

30분

## :pushpin: \*\*Algorith

- dp

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 제일 위에 (0,0) 좌표에서 부터 차례대로 탐색을 해준다.
2. 초기값으로 (0,0)을 채워준다.
3. 제일 왼쪽은 이전칸에 n번째, 제일 오른쪽은 이전칸에 n-1넣어주고 그외에는 둘중에 큰값을 넣어서계산
4. 마지막에 왔을때 결과값이랑 비교해서 큰값이면 변경

```java
          dp[0][0] = arr[0][0];
        for(int depth =1 ; depth<len; depth++){
            for(int i =0; i <= depth; i++){
                int max = 0;
                
                if(i==0){
                    max = dp[depth-1][i];
                }else if(i == depth){
                    max = dp[depth-1][i-1]; 
                }else{
                   max = Math.max(dp[depth - 1][i], dp[depth - 1][i - 1]);
                }
                dp[depth][i]= max + arr[depth][i];
                if(answer<dp[depth][i]){
                    answer=dp[depth][i];
                }
            }
        }
```



## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/parts/12263>
