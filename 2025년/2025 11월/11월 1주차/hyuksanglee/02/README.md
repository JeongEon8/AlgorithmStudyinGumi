# [프로그래머스 - Lv2] PCCP_2번. 퍼즐게임챌린지

## ⏰  **time**
80분

## :pushpin: **Algorithm**
- 이분탐색

## ⏲️**Time Complexity**
$O(n log n + n log M)$

## :round_pushpin: **Logic**
1. 순서에 맞게 이전 값과 현재값합을 구해주고 diffs 크기 별로 정렬해준다.
    
    ex) diffs: [1, 5, 3] times: [2, 4, 7] 
    
    arr {1 : 2}, {5 : 6} , {3 : 11} 이런식으로 누럽합을 구해주고 
    arr {1 : 2}, {3 : 11}, {5 : 6} 이렇게 다시 정렬해준다.
    
2. 레벨이 가장 큰 값에서 하나씩 줄여준다. 
    - 5 → 4 → 3 →2 →1 이런식으로
    - 처음에는 5이므로 한번에 다 풀 수 있으므로 2 + 4 + 7 = 13
    - 4이면 5는 한번 더 풀어야하므로 기존에 더한것에서 5의 누접합 6을 더해준다. 13 + 6 = 19
    - 3 이면 19+6 = 25
    - 2 이면 25 + 6 + 11 = 44
        - 44 는 30보다 초과하므로 3이 정답
```java
	for(int i = 0; i<diffs.length; i++){
            if(i == 0){
                Info info = new Info(diffs[i],times[i]);
                infos[i] = info;
            }else{
                Info info = new Info(diffs[i],times[i]+times[i-1]);
                infos[i] = info;
            }   
        }
        Arrays.sort(infos);
        
       
        int left =1;
        int right = maxLev;
        
        while(left<=right){
            long total2 = total;
            int mid = (left+right) /2;
             for(int i =0; i< infos.length; i++){
                if(infos[i].lev <= mid){
                    break;
                }
               total2 += (infos[i].time*(infos[i].lev-mid));
            }
             if (total2 <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
```



## :black_nib: **Review**
- 14번 테케는 왜 left가 0이면 안되는지 모르겠어요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/340212
