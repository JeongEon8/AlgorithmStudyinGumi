# [프로그래머스 - Lv3] 연습문제 인사고과

## ⏰  **time**
60분

## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**
$O(log N)$

## :round_pushpin: **Logic**
- 완호의 값을 태도 점수와 동료점수, 총합을 저장해둔다.
- 태도 점수를 기준으로 높은순으로 동료 점수 낮은순으로 정렬.
  
 ```java
 Arrays.sort(scores, (a,b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1]; 
        });
```
- 두번째 사원부터 하나씩 비교
- 이전 동료랑 지금 동료랑 비교했을때 둘다 낮으면 비교 등수 패스한다.
- 태도점수와 동료점수가 둘다 낮으면 -1을 출력하고
- 그게 아닐경우 총합을 비교하여높으면 answer을 +1해준다.
- 끝까지 돌았으면 answer을 출력

```java
	for(int i = 0; i<scores.length; i++){
            int w = scores[i][0];
            int c = scores[i][1];
            int t = w+c;
            
            if(scoreW<w && scoreC<c){
                return -1;
            }
            
            if(w<pw && c < pc){
               
                continue;
            }
            pw=w; 
            pc=c;
            if(total<t){
                answer ++;
            }
        }
```


## :black_nib: **Review**
- 2번 틀렸어요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/152995
