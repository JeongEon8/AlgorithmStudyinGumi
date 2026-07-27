# [PGS - Lv2] 02_최댓값과 최솟값

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 문자를 split을 통해서 쪼개고 int 바꿔서 최댓값과 최솟값을 찾아준다.
   ```
   int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = s.split(" ");
        
        for(int i = 0; i<str.length; i++){
            int num = Integer.parseInt(str[i]);
            if(max < num){
                max = num;
            }
            if(min >num){
                min = num;
            }
        }
   ```

## :black_nib: **Review**

- 이번주 시간이 별로 없어서 쉬운거 풀었어요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12939
