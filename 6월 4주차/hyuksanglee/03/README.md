# [PGS - Lv2] 03_[PCCP 기출문제] 2번 퍼즐 게임 챌린지

## ⏰**time**

- 1시간

## :pushpin: **Algorithm**

- 이분탐색
- 시뮬레이션

## ⏲️**Time Complexity**

$O(NlongN)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**
- 1 ~ 100,000까지중 적당한 수를 골라서 이 숫자가 최선인지 구하는문제라고 생각함
=> 이분 탐색으로 구하면 되겠다고 생각함

1. diffs에서 가장 큰 값 찾기
   ```
     int end =0;
        for( int diff : diffs){
            if( end<diff){
                end = diff;
            }
        }
        end+=1;
   ```

2. 이분 탐색 시작(시작점 : 1, 끝점 : '1번'에서 구한 값)
   ```
     while(start<=end){
            int min = (start+end)/2;
            long current = 0;
            int type = 0;
            
            for(int i = 0; i<diffs.length; i++){
                int diff = diffs[i];
                int time = times[i];
                int pre = 0;
                if(i !=0){
                    pre = times[i-1];
                }
                current += step(min, diff, time, pre);
                if(current>limit){
                    type =1;
                    break;
                }
            }
            if(type ==1 || current>limit){
                start = min +1;
                
                
            }else{
                answer = min;
                end = min-1;
                
            }
            
        }
   ```
2-1. 문제에서 나온 level이 diff보다 클경우 현제 문제 푼 시간을 더하고 작을경우 이전 푼 시간과 푼시간을 level차이 만큼 곱해서 더해준다.
   ```
    public long step(int level, int diff, int time, int current){
        if(level>=diff){
            return time;
        }
        long count = diff-level;
        long solved = (long)(current+time)*count + time;
        return solved;
        
     }
   ```
## :black_nib: **Review**

- 처음에 end값을 구할때 diffs에서 찾아야하는데 times에서 찾아서 왜 틀렸는지 찾는데 걸린거같아요 
=> 다음에 풀때는 코드를 작성할때 제대로 차근차근 작성해야겠어요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/340212?language=java
